package functions

/**
 * Kotlin functions are first-class, which means that they can be stored in variables and
 * data structures, passed as arguments to and returned from other higher-order functions.
 * You can operate with functions in any way that is possible for other non-function
 * values. To facilitate this, Kotlin, as a statically typed programming language, uses a
 * family of function types to represent functions and provides a set of specialized
 * language constructs, such as lambda expressions
 */

/**
 * A higher-order function is a function that takes functions as parameters, or returns
 * a function.
 * A good example is the functional programming idiom 'fold' for collections, which takes
 * an initial accumulator value and a combining function and builds its return value by
 * consecutively combining current accumulator value with each collection element,
 * replacing the accumulator
 */
fun <T, R> Collection<T>.fold(
    initial: R,
    combine: (acc: R, nextElement: T) -> R
): R {
    var accumulator: R = initial
    for (element: T in this) {
        // this refers to Collection
        accumulator = combine(accumulator, element)
    }
    return accumulator
}

fun main() {
    val items = listOf(1, 2, 3, 4, 5)

    // lambdas are code blocks enclosed in curly braces
    items.fold(0, {
        // when a lambda has parameters, they go first, followed by '->'
        acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // the last expression in a lambda is considered the return value
        result
    })

    // Parameter types in a lambda are optional if they can be inferred:
    val joinedToString = items.fold("Elements:", { acc, i -> "$acc $i" })

    // Function references can also be used for higher-order function calls:
    val product = items.fold(1, Int::times)
}