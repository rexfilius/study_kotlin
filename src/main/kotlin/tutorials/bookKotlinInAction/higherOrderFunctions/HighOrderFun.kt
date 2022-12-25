package higherOrderFunctions

/**
 * - A higher-order function is a function that takes another function as an argument
 * or returns one.
 * - In Kotlin, functions can be represented as values using lambdas or function
 * references. Therefore, a higher-order function is any function to which you can
 * pass a lambda or a function reference as an argument, or a function which returns
 * one, or both. e.g. the filter standard-library function takes a predicate function
 * as an argument and is therefore a higher-order function.
 * - In order to declare a function that takes a lambda as an argument, you need to
 * know how to declare the type of the corresponding parameter.
 */
val sumImplicit = { x: Int, y: Int -> x + y }
val actionImplicit = { println(42) }

/**
 * - In the code above, the compiler infers that both the sumImplicit & actionImplicit
 * variables have function types.
 * - In the code below, sumExplicit takes two Int parameters and returns an Int value.
 * actionExplicit takes no arguments and doesn't return a value.
 * - To declare a function type, you put the function parameter types in parentheses,
 * followed by an arrow and the return type of the function
 * - NOTE: the Unit type is used to specify that a function returns no meaningful
 * value. The Unit return type can be omitted when you declare a regular function,
 * but a function type declaration always requires an explicit return type, so you
 * can't omit Unit in this context.
 */
val sumExplicit: (Int, Int) -> Int = { x, y -> x + y }
val actionExplicit: () -> Unit = { println(42) }

/**
 * Just like with any other function, the return type of a 'function type' can be
 * marked as nullable
 */
var canReturnNull: (Int, Int) -> Int? = { _, _ -> null }

/**
 * You can also define a nullable variable of a function type. To specify that the
 * variable itself, rather than the return type of the function, is nullable, you need
 * to enclose the entire function type definition in parentheses and put the question
 * mark after the parentheses
 */
var funOrNull: ((Int, Int) -> Int)? = null

/**
 * You can specify names for parameters of a function type.
 */
fun performRequest(
    url: String,
    callback: (code: Int, content: String) -> Unit
) {
}

fun main() {
    /**
     * Parameter names don't affect type matching. When you declare a lambda,
     * you don't have to use the same parameter names as the ones used in the
     * function type declaration. But the names improve readability of the code
     * and can be used in the IDE for code completion.
     */
    val url = "http://kotl.in"
    performRequest(url) {code, content -> }
    performRequest(url) { code, page -> }
}