package documentation.functions

/**
 * In Kotlin, there is a convention: if the last parameter of a function is a function,
 * then a lambda expression passed as the corresponding argument can be placed
 * outside the parentheses
 */
val num = listOf(1, 2, 3, 4, 5, 6, 7, 8)
val product = num.fold(1) { acc, e -> acc * e }

// above syntax is known as 'trailing lambda'. If the lambda is the only argument to that
// call, the parentheses can be omitted entirely.
val d = run { println("Jaded") }

/**
 * It's very common that a lambda expression has only one parameter. If the compiler can
 * figure the signature out itself, it is allowed not to declare the only parameter and
 * omit '->'. The parameter will be implicitly declared under the name it
 */
val numFilter = num.filter { it % 2 == 0 } // (it:Int) -> Boolean

// You can explicitly return a value from the lambda using the qualified return syntax.
// Otherwise, the value of the last expression is implicitly returned.
val a1 = num.filter {
    val shouldFilter = it > 2
    shouldFilter
}

// same as 'a1' above
val a2 = num.filter {
    val shouldFilter = it > 2
    return@filter shouldFilter
}

// this convention allows for LINQ-style code
val cities = listOf("Tokyo", "Paris", "New York", "Toronto", "Madrid", "Moscow")
val c = cities.filter { it.length > 5 }.sortedBy { it }.map { it.uppercase() }

// If the lambda parameter is unused, you can place an underscore instead of its name
val cc = cities.forEach { _ -> println("$cities") }

