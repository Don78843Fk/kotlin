/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

// This file was generated automatically. See compiler/ir/bir.tree/tree-generator/ReadMe.md.
// DO NOT MODIFY IT MANUALLY.

package org.jetbrains.kotlin.bir.expressions.impl

import org.jetbrains.kotlin.bir.BirElement
import org.jetbrains.kotlin.bir.BirElementVisitorLite
import org.jetbrains.kotlin.bir.SourceSpan
import org.jetbrains.kotlin.bir.acceptLite
import org.jetbrains.kotlin.bir.declarations.BirAttributeContainer
import org.jetbrains.kotlin.bir.expressions.BirExpression
import org.jetbrains.kotlin.bir.expressions.BirTypeOperatorCall
import org.jetbrains.kotlin.bir.types.BirType
import org.jetbrains.kotlin.ir.expressions.IrTypeOperator

class BirTypeOperatorCallImpl(
    sourceSpan: SourceSpan,
    type: BirType,
    operator: IrTypeOperator,
    argument: BirExpression?,
    typeOperand: BirType,
) : BirTypeOperatorCall(BirTypeOperatorCall) {
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

    private var _attributeOwnerId: BirAttributeContainer = this
    override var attributeOwnerId: BirAttributeContainer
        get() {
            recordPropertyRead(2)
            return _attributeOwnerId
        }
        set(value) {
            if (_attributeOwnerId !== value) {
                _attributeOwnerId = value
                invalidate(2)
            }
        }

    private var _type: BirType = type
    override var type: BirType
        get() {
            recordPropertyRead(3)
            return _type
        }
        set(value) {
            if (_type != value) {
                _type = value
                invalidate(3)
            }
        }

    private var _operator: IrTypeOperator = operator
    override var operator: IrTypeOperator
        get() {
            recordPropertyRead(4)
            return _operator
        }
        set(value) {
            if (_operator != value) {
                _operator = value
                invalidate(4)
            }
        }

    private var _argument: BirExpression? = argument
    override var argument: BirExpression?
        get() {
            recordPropertyRead(1)
            return _argument
        }
        set(value) {
            if (_argument !== value) {
                childReplaced(_argument, value)
                _argument = value
                invalidate(1)
            }
        }

    private var _typeOperand: BirType = typeOperand
    override var typeOperand: BirType
        get() {
            recordPropertyRead(5)
            return _typeOperand
        }
        set(value) {
            if (_typeOperand != value) {
                _typeOperand = value
                invalidate(5)
            }
        }


    init {
        initChild(_argument)
    }

    override fun acceptChildrenLite(visitor: BirElementVisitorLite) {
        _argument?.acceptLite(visitor)
    }

    override fun replaceChildProperty(old: BirElement, new: BirElement?): Int {
        return when {
            this._argument === old -> {
                this._argument = new as BirExpression?
                1
            }
            else -> throwChildForReplacementNotFound(old)
        }
    }
}
