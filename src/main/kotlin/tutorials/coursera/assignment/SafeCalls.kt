package assignment

fun main() {
    val s = "abc"
    println(s as? Int)  // ans = null
    println(s as Int?)  // ans = ClassCastException
}