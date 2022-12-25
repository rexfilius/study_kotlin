package controlFlow

import newLine

/**
 * Instead of the widely used switch statement, Kotlin provides the more flexible and
 * clear when construction. It can be used either as a statement or as an expression.
 */
fun main() {

    cases("Hello")
    cases(1)
    cases(0L)
    cases(MyClass())
    cases("hello")
    "" newLine ""

    println(whenAssign("Hello"))
    println(whenAssign(3.4))
    println(whenAssign(1))
    println(whenAssign(MyClass()))

}

/**
 * When statement. NOTE that all branch conditions are checked sequentially until one of
 * them is satisfied. So, only the first suitable branch will be executed.
 */
fun cases(obj: Any) {
    when (obj) {
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("Unknown")
    }
}

/**
 * When expression. Unlike in 'when' statement, the default branch 'else' is usually
 * required in 'when' expression, except the case when the compiler can check that other
 * branches cover all possible cases.
 */
fun whenAssign(obj: Any): Any {
    return when (obj) {
        1 -> "one"
        "Hello" -> 1
        is Long -> false
        else -> 42
    }
}

class MyClass