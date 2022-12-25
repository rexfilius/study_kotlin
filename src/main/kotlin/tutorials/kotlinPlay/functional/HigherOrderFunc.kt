package functional

import newLine

/**
 * A higher-order function is a function that takes another function as parameter
 * and/or returns a function ... The function below takes two integer parameters, x and y.
 * Additionally, it takes another function operation as a parameter. The operation
 * parameters and return type are also defined in the declaration. This higher order
 * function returns the result of operation invocation with the supplied arguments.
 */
fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

/**
 * Declares a function that matches the operation signature above.
 */
fun summation(x: Int, y: Int) = x + y

/**
 * A higher-order function that returns a function. (Int) -> Int represents the parameters
 * and return type of the [square] function.
 */
fun operate(): (Int) -> Int {
    return ::square
}

/**
 * A function matching the signature above.
 */
fun square(x: Int) = x * x

fun main() {

    /**
     * Invokes the higher-order function passing in two integer values and the function
     * argument '::sum'. "::" is the notation that references a function by name in Kotlin.
     */
    val sumResult = calculate(4, 5, ::summation)
    println("sumResult: $sumResult")

    /**
     * Invokes the higher-order function passing in a lambda as a function argument
     */
    val mulResult = calculate(4, 5) { a, b -> a * b }
    println("mulResult $mulResult")

    val divideResult = calculate(10, 2) { a, b -> a / b }
    println("divideResult: $divideResult")
    "" newLine ""

    /**
     * Invokes [operate] to get the result assigned to a variable. Here func becomes
     * [square] which is returned by operation.
     */
    val func = operate()

    // Invokes func. The square function is actually executed.
    println(func(2))
}