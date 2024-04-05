package kotlin

@AnnotationWithInt(Int.MAX_VALUE)
class TestClassInPlatform

fun test() {
    val any = Any()
    val string = "OK"
    val boolean = true
    val int = 42
}