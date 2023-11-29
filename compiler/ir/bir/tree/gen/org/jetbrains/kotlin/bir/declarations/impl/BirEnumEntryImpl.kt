/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

// This file was generated automatically. See compiler/ir/bir.tree/tree-generator/ReadMe.md.
// DO NOT MODIFY IT MANUALLY.

package org.jetbrains.kotlin.bir.declarations.impl

import org.jetbrains.kotlin.bir.*
import org.jetbrains.kotlin.bir.declarations.BirClass
import org.jetbrains.kotlin.bir.declarations.BirEnumEntry
import org.jetbrains.kotlin.bir.expressions.BirConstructorCall
import org.jetbrains.kotlin.bir.expressions.BirExpressionBody
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.ir.ObsoleteDescriptorBasedAPI
import org.jetbrains.kotlin.ir.declarations.IrDeclarationOrigin
import org.jetbrains.kotlin.ir.util.IdSignature
import org.jetbrains.kotlin.name.Name

class BirEnumEntryImpl(
    sourceSpan: SourceSpan,
    signature: IdSignature?,
    origin: IrDeclarationOrigin,
    name: Name,
    descriptor: ClassDescriptor?,
    initializerExpression: BirExpressionBody?,
    correspondingClass: BirClass?,
) : BirImplElementBase(), BirEnumEntry {
    override val owner: BirEnumEntryImpl
        get() = this

    private var _sourceSpan: SourceSpan = sourceSpan
    /**
     * The span of source code of the syntax node from which this BIR node was generated,
     * in number of characters from the start the source file. If there is no source information for this BIR node,
     * the [SourceSpan.UNDEFINED] is used. In order to get the line number and the column number from this offset,
     * [IrFileEntry.getLineNumber] and [IrFileEntry.getColumnNumber] can be used.
     *
     * @see IrFileEntry.getSourceRangeInfo
     */
    override var sourceSpan: SourceSpan
        get() {
            recordPropertyRead(6)
            return _sourceSpan
        }
        set(value) {
            if (_sourceSpan != value) {
                _sourceSpan = value
                invalidate(6)
            }
        }

    private var _signature: IdSignature? = signature
    override var signature: IdSignature?
        get() {
            recordPropertyRead(7)
            return _signature
        }
        set(value) {
            if (_signature != value) {
                _signature = value
                invalidate(7)
            }
        }

    private var _origin: IrDeclarationOrigin = origin
    override var origin: IrDeclarationOrigin
        get() {
            recordPropertyRead(4)
            return _origin
        }
        set(value) {
            if (_origin != value) {
                _origin = value
                invalidate(4)
            }
        }

    private var _name: Name = name
    override var name: Name
        get() {
            recordPropertyRead(5)
            return _name
        }
        set(value) {
            if (_name != value) {
                _name = value
                invalidate(5)
            }
        }

    @ObsoleteDescriptorBasedAPI
    override val descriptor: ClassDescriptor? = descriptor

    private var _initializerExpression: BirExpressionBody? = initializerExpression
    override var initializerExpression: BirExpressionBody?
        get() {
            recordPropertyRead(2)
            return _initializerExpression
        }
        set(value) {
            if (_initializerExpression != value) {
                childReplaced(_initializerExpression, value)
                _initializerExpression = value
                invalidate(2)
            }
        }

    private var _correspondingClass: BirClass? = correspondingClass
    override var correspondingClass: BirClass?
        get() {
            recordPropertyRead(3)
            return _correspondingClass
        }
        set(value) {
            if (_correspondingClass != value) {
                childReplaced(_correspondingClass, value)
                _correspondingClass = value
                invalidate(3)
            }
        }

    override val annotations: BirImplChildElementList<BirConstructorCall> = BirImplChildElementList(this, 1, false)

    init {
        initChild(_initializerExpression)
        initChild(_correspondingClass)
    }

    override fun acceptChildrenLite(visitor: BirElementVisitorLite) {
        annotations.acceptChildrenLite(visitor)
        _initializerExpression?.acceptLite(visitor)
        _correspondingClass?.acceptLite(visitor)
    }

    override fun replaceChildProperty(old: BirElement, new: BirElement?): Int {
        return when {
            this._initializerExpression === old -> {
                this._initializerExpression = new as BirExpressionBody?
                2
            }
            this._correspondingClass === old -> {
                this._correspondingClass = new as BirClass?
                3
            }
            else -> throwChildForReplacementNotFound(old)
        }
    }

    override fun getChildrenListById(id: Int): BirChildElementList<*> {
        return when (id) {
            1 -> this.annotations
            else -> throwChildrenListWithIdNotFound(id)
        }
    }
}
