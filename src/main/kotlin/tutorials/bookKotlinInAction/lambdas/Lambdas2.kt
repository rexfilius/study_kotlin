package lambdas

/**
 * - A lambda encodes a small piece of behavior that you can pass around as a value.
 * It can be declared independently and stored in a variable. But more frequently,
 * it's declared directly when passed to a function.
 * - A lambda expression in Kotlin is always surrounded by curly braces. Note that
 * there are no parentheses around the arguments. The arrow separates the argument
 * list from the body of the lambda.
 * - You can store a lambda expression in a variable and then treat this variable
 * like a normal function (call it with the corresponding arguments)
 */
val summer = { x: Int, y: Int -> x + y }

fun main() {
    println(summer(2, 4))

    val people4 = listOf(
        PersonG("Alice", 29),
        PersonG("Bob", 32),
        PersonG("Jake", 42)
    )
    println(people4.maxByOrNull { p: PersonG -> p.age })

    // Passing a lambda as a named argument
    val people5 = listOf(
        PersonG("Alice", 29),
        PersonG("Bob", 32),
        PersonG("Jake", 42)
    )
    val names5 = people5.joinToString(
        separator = " ",
        transform = { p: PersonG -> p.name }
    )
    println(names5)

    // Rewriting the above another way
    val people6 = listOf(
        PersonG("Alice", 29),
        PersonG("Bob", 32),
        PersonG("Jake", 42)
    )
    val names6 = people6.joinToString(" ") { p: PersonG -> p.name }
    println(names6)

    /**
     * Lambdas can contain multiple statements.
     * code below: the last expression is the result
     */
    val summed = { x: Int, y: Int ->
        println("Computing the sum of $x and $y")
        x + y
    }
    println(summed(4,6))
}