package functions

import kotlin.math.abs
import kotlin.math.cos

/**
 * Kotlin functions can be declared at the top level in a file, meaning you do not need to
 * create a class to hold a function, which you are required to do in languages such as
 * Java, C# or Scala. In addition to top level functions, Kotlin functions can also be
 * declared locally, as member functions and extension functions
 * ...
 * Kotlin supports local functions, which are functions inside another function.
 * A local function can access local variables of outer functions (the closure).
 * A member function is a function that is defines inside a class or object.
 * Member functions are called with 'dot notation'.
 * Functions can have generic parameters which are specified using angle brackets
 * before the function name.
 */

/**
 * TAIL RECURSIVE FUNCTIONS.
 * Kotlin supports a style of functional programming known as tail recursion. For some
 * algorithms that would normally use loops you can use a recursive function instead
 * without a risk of stack overflow. When a function is marked with the 'tailrec' modifier
 * and meets the required form, the compiler optimizes out the recursion, leaving behind
 * a fast and efficient loop based version instead
 */
val eps = 1E-10

tailrec fun findFixPoint(x: Double = 1.0): Double =
    if (abs(x - cos(x)) < eps) x else findFixPoint(cos(x))

// code below is a more traditional way of writing the tailrec function above
fun findFixPoint2(): Double {
    var x = 1.0
    while (true) {
        val y = cos(x)
        if (abs(x - y) < eps)
            return x
        x = cos(x)
    }
}

/**
 * To be eligible for the tailrec modifier, a function must call itself as the last
 * operation it performs. You cannot use tail recursion when there is more code after
 * the recursive call, and you cannot use it within try-catch-finally blocks
 */