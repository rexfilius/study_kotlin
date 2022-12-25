package higherOrderFunctions

/**
 * Defining a simple higher-order function
 */
fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

// ASIDE: function types can have a default value.

fun main() {
    twoAndThree { a, b -> a + b }
    twoAndThree { a, b -> a * b }
}

