package kotlin

enum class TestEnumInPlatform {
    D, E, F
}

@AnnotationWithInt(Int.MAX_VALUE)
class TestClassInPlatform

fun initCauseInPlatform() = Throwable().initCause(Throwable()) // `initCause` is not visible in `common` but visible in `platform`

fun test() {
    val any = Any()
    val string = "OK"
    val boolean = true
    val int = 42
}