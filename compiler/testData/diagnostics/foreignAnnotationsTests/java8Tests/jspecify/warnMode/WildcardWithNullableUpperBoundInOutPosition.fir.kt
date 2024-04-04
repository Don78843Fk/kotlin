// JSPECIFY_STATE: warn
// DIAGNOSTICS: -UNUSED_PARAMETER
// ISSUE: KT-66946

// FILE: FromJava.java

import org.jspecify.annotations.*;

@NullMarked
public class FromJava<T extends @Nullable Object> {
    public T produce() { return null; }

    public static FromJava<? extends @Nullable Object> EXPLICIT_UPPER_BOUND = new FromJava<@Nullable Object>();
    public static FromJava<? super @Nullable Object> EXPLICIT_LOWER_BOUND = new FromJava<@Nullable Object>();
    public static FromJava<?> IMPLICIT_BOUNDS = new FromJava<@Nullable Object>();
}

// FILE: kotlin.kt

fun <T> accept(arg: T) {}

fun test() {
    accept<Any?>(FromJava.EXPLICIT_UPPER_BOUND.produce())
    accept<Any>(FromJava.EXPLICIT_UPPER_BOUND.produce())

    accept<Any?>(FromJava.EXPLICIT_LOWER_BOUND.produce())
    // jspecify_nullness_mismatch
    accept<Any>(<!NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS!>FromJava.EXPLICIT_LOWER_BOUND.produce()<!>)

    accept<Any?>(FromJava.IMPLICIT_BOUNDS.produce())
    accept<Any>(FromJava.IMPLICIT_BOUNDS.produce())
}
