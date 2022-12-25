package functions

fun main() {

    /**
     * INVOKING A FUNCTION TYPE INSTANCE
     * A value of a function type can be invoked by using its invoke(...) operator:
     * f.invoke(typeSystem.getX) or just f(typeSystem.getX). If the value has a receiver type, the receiver object
     * should be passed as the first argument. Another way to invoke a value of a function
     * type with receiver is to prepend it with the receiver object, as if the value were
     * an extension function: 1.foo(2)
     */
    val stringPlus: (String, String) -> String = String::plus
    val intPlus: Int.(Int) -> Int = Int::plus

    println(stringPlus.invoke("<-", "->"))
    println(stringPlus("Hello, ", "world!"))

    println(intPlus.invoke(1, 1))
    println(intPlus(1, 2))
    println(2.intPlus(3))  // extension-like call

    /**
     * Lambda expressions and anonymous functions are function literals. Function literals
     * are functions that are not declared but passed immediately as an expression.
     */

    // max(strings, { a, b -> a.length < b.length })

    /**
     * Function max is a higher-order function, it takes a function value as the second
     * argument. This second argument is an expression that is itself a function, called a
     * function literal, which is equivalent to the following named function:
     */

    // fun compare(a: String, b: String): Boolean = a.length < b.length

    //The full syntactic form of lambda expressions is as follows:
    val som: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    // OR
    val some = { x: Int, y: Int -> x + y }

    /**
     * 1. A lambda expression is always surrounded by curly braces.
     * 2. Parameter declarations in the full syntactic form go inside curly braces
     *    and have optional type annotations
     * 3. The body goes after an -> sign
     * 4. If the inferred return type of the lambda is not Unit, the last (or possibly
     *    single) expression inside the lambda body is treated as the return value.
     */

}

