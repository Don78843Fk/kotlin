/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.resolve.dfa

import org.jetbrains.kotlin.fir.FirElement
import org.jetbrains.kotlin.fir.declarations.FirDeclaration
import org.jetbrains.kotlin.fir.expressions.*
import org.jetbrains.kotlin.fir.references.symbol
import org.jetbrains.kotlin.fir.symbols.FirBasedSymbol
import org.jetbrains.kotlin.fir.symbols.impl.*
import org.jetbrains.kotlin.fir.unwrapFakeOverrides
import org.jetbrains.kotlin.fir.util.SetMultimap
import org.jetbrains.kotlin.fir.util.setMultimapOf

abstract class VariableStorage {
    // This is basically a set, since it maps each key to itself. The only point of having it as a map
    // is to deduplicate equal instances with lookups. The impact of that is questionable, but whatever.
    private val realVariables: MutableMap<RealVariable, RealVariable> = HashMap()

    private val memberVariables: SetMultimap<RealVariable, RealVariable> = setMultimapOf()

    // TODO: this information should be stored in flows, as it depends on location
    abstract fun RealVariable.isUnstable(): Boolean

    fun getAllLocalVariables(): List<RealVariable> =
        realVariables.values.filter { (it.symbol as? FirPropertySymbol)?.isLocal == true }

    // Use this when making non-type statements, such as `variable eq true`.
    // Returns null if the statement would be useless (the variable has not been used in any implications).
    fun getIfUsed(flow: Flow, fir: FirElement): DataFlowVariable? =
        getImpl(flow, fir, createReal = false, unwrapAlias = true)?.takeIf { !flow.getImplications(it).isNullOrEmpty() }

    // Use this when making type statements, such as `variable typeEq ...` or `variable notEq null`.
    // Returns null if the statement would be useless (the variable is synthetic and has not been used in any implications).
    fun getOrCreateIfReal(flow: Flow, fir: FirElement): DataFlowVariable? =
        getImpl(flow, fir, createReal = true, unwrapAlias = true)?.takeIf { it.isReal() || !flow.getImplications(it).isNullOrEmpty() }

    // Use this for variables on the left side of an implication.
    // Returns null only if the variable is an unstable alias, and so cannot be used at all.
    fun getOrCreate(flow: Flow, fir: FirElement): DataFlowVariable? =
        getImpl(flow, fir, createReal = true, unwrapAlias = true)

    // Use this for variables on the left side of an implication if `fir` is known to not be a variable access.
    // Equivalent to `getOrCreate` in those cases, but doesn't spend time validating the precondition.
    fun createSynthetic(fir: FirElement): SyntheticVariable =
        SyntheticVariable(fir.unwrapElement())

    // Use this for calling `getTypeStatement` or accessing reassignment information.
    // Returns null if it's already known that no statements about the variable were made ever.
    fun getRealVariableWithoutUnwrappingAlias(flow: Flow, fir: FirElement): RealVariable? =
        getImpl(flow, fir, createReal = false, unwrapAlias = false) as? RealVariable

    // Use this when adding statements to a variable initialization.
    // Returns null only if `fir` is not a variable declaration or assignment. Ideally, that shouldn't happen.
    fun getOrCreateRealVariableWithoutUnwrappingAlias(flow: Flow, fir: FirElement): RealVariable? =
        getImpl(flow, fir, createReal = true, unwrapAlias = false) as? RealVariable

    private fun getImpl(flow: Flow, fir: FirElement, createReal: Boolean, unwrapAlias: Boolean): DataFlowVariable? {
        val unwrapped = fir.unwrapElement()
        val symbol = unwrapped.symbol ?: return SyntheticVariable(unwrapped)
        val qualifiedAccess = unwrapped as? FirQualifiedAccessExpression
        val dispatchReceiverVar = qualifiedAccess?.dispatchReceiver?.let {
            (getImpl(flow, it, createReal, unwrapAlias = true) ?: return null) as? RealVariable ?: return SyntheticVariable(unwrapped)
        }
        val extensionReceiverVar = qualifiedAccess?.extensionReceiver?.let {
            (getImpl(flow, it, createReal, unwrapAlias = true) ?: return null) as? RealVariable ?: return SyntheticVariable(unwrapped)
        }
        val isReceiver = unwrapped is FirThisReceiverExpression
        val prototype = RealVariable(symbol, isReceiver, dispatchReceiverVar, extensionReceiverVar)
        val real = if (createReal) prototype.remember() else realVariables[prototype] ?: return null
        return if (unwrapAlias)
            flow.unwrapVariable(real).takeIf { it == real || !real.isUnstable() }
        else
            real
    }

    private fun RealVariable.remember(): RealVariable =
        realVariables.getOrPut(this) {
            dispatchReceiver?.let { memberVariables.put(it, this) }
            extensionReceiver?.let { memberVariables.put(it, this) }
            this
        }

    fun replaceReceiverReferencesInMembers(from: RealVariable, to: RealVariable?, processMember: (RealVariable, RealVariable?) -> Unit) {
        for (member in memberVariables[from]) {
            val remapped = to?.let {
                val dispatchReceiver = if (member.dispatchReceiver == from) to else member.dispatchReceiver
                val extensionReceiver = if (member.extensionReceiver == from) to else member.extensionReceiver
                member.copy(dispatchReceiver = dispatchReceiver, extensionReceiver = extensionReceiver).remember()
            }
            processMember(member, remapped)
        }
    }
}

private tailrec fun FirElement.unwrapElement(): FirElement {
    return when (this) {
        is FirWhenSubjectExpression -> whenRef.value.let { it.subjectVariable ?: it.subject ?: return this }.unwrapElement()
        is FirSmartCastExpression -> originalExpression.unwrapElement()
        is FirSafeCallExpression -> selector.unwrapElement()
        is FirCheckedSafeCallSubject -> originalReceiverRef.value.unwrapElement()
        is FirCheckNotNullCall -> argument.unwrapElement()
        is FirDesugaredAssignmentValueReferenceExpression -> expressionRef.value.unwrapElement()
        is FirVariableAssignment -> lValue.unwrapElement()
        else -> this
    }
}

private val FirElement.symbol: FirBasedSymbol<*>?
    get() = when (this) {
        is FirDeclaration -> symbol
        is FirResolvable -> calleeReference.symbol
        is FirResolvedQualifier -> symbol
        // Only called on the result of `unwrapElement, so handling all those cases here is redundant.
        else -> null
    }?.takeIf {
        this is FirThisReceiverExpression || it is FirClassSymbol || (it is FirVariableSymbol && it !is FirSyntheticPropertySymbol)
    }?.unwrapFakeOverridesIfNecessary()

private fun FirBasedSymbol<*>?.unwrapFakeOverridesIfNecessary(): FirBasedSymbol<*>? {
    if (this !is FirCallableSymbol) return this
    // This is necessary only for sake of optimizations because this is a really hot place.
    // Not having `dispatchReceiverType` means that this is a local/top-level property that can't be a fake override.
    // And at the same time, checking a field is much faster than a couple of attributes (0.3 secs at MT Full Kotlin)
    if (this.dispatchReceiverType == null) return this
    return this.unwrapFakeOverrides()
}
