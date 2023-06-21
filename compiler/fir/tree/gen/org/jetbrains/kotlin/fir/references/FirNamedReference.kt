/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.references

import org.jetbrains.kotlin.KtSourceElement
import org.jetbrains.kotlin.fir.FirElementInterface
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.fir.visitors.*

/*
 * This file was generated automatically
 * DO NOT MODIFY IT MANUALLY
 */

abstract class FirNamedReference : FirReference() {
    abstract override val source: KtSourceElement?
    abstract val name: Name

    override fun <R, D> accept(visitor: FirVisitor<R, D>, data: D): R = visitor.visitNamedReference(this, data)

    @Suppress("UNCHECKED_CAST")
    override fun <E : FirElementInterface, D> transform(transformer: FirTransformer<D>, data: D): E =
        transformer.transformNamedReference(this, data) as E
}
