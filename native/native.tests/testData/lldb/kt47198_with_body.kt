// KIND: STANDALONE_LLDB
// LLDB_TRACE: kt47198_with_body.txt
// FILE: kt47198.kt
fun foo(a:Int){
    print("a: ${'$'}a")
}

fun main() {
    foo(33)
}
