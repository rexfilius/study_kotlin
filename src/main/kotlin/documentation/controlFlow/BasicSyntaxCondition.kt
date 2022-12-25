package controlFlow

fun main() {
    println(maxOf(3, 45))
    println(maxOf2(2, 5))
}

fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

// in Kotlin, if can also be used as an expression
fun maxOf2(a: Int, b: Int) = if (a > b) a else b