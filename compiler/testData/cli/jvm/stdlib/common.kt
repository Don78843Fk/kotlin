// ISSUE: KT-65841

@file:Suppress("EXPECTED_PROPERTY_INITIALIZER")

package kotlin

internal annotation class ActualizeByJvmBuiltinProvider

@ActualizeByJvmBuiltinProvider
expect open class Any() {
    public open operator fun equals(other: Any?): Boolean

    public open fun hashCode(): Int

    public open fun toString(): String
}

@ActualizeByJvmBuiltinProvider
expect class Boolean

@ActualizeByJvmBuiltinProvider
expect class Int {
    companion object {
        const val MIN_VALUE: Int = -2147483648
        const val MAX_VALUE: Int = 2147483647
    }
}

@ActualizeByJvmBuiltinProvider
expect class String

annotation class AnnotationWithInt(val value: Int)

@AnnotationWithInt(Int.MAX_VALUE)
class TestClassInCommon