package documentation.otherConcepts.idioms

fun main() {

    // filtering a list
    val numbers = listOf(2, 4, -5, -10, 3, 7, -9)
    val positives = numbers.filter { it > 0 }
    println("$positives")
    println()

    // Checking the presence of an element in a collection
    val emailsList = listOf("John@typeSystem.getX.com", "Jane@typeSystem.getX.com", "Alice@typeSystem.getX.com", "Yu@typeSystem.getX.com")
    if ("Yu@typeSystem.getX.com" in emailsList) {
        println("${emailsList[3]} is part of the email list")
    }
    if ("Jon@typeSystem.getX.com" !in emailsList) {
        println("email list has no record of Jon@typeSystem.getX.com")
    }
    println()

    // String interpolation
    val name = "Kelvin"
    println("My name is $name")

    // A Read-only list
    val alphabets = listOf("a", "b", "c", "d")

    // A Read-only map
    val mapping = mapOf("a" to 1, "b" to 2, "c" to 3, "d" to 4)

    // Accessing a map entry
    println(mapping["a"])

    // traverse a map or a list of maps
    for ((key, value) in mapping) {
        println("$key -> $value")
    }
}

/**
 * Create DTOs (POJOs/POCOs).
 * provides a Customer class with the following functionality:
 * getters (and setters in case of var s) for all properties;
 * equals(), hashCode(), toString(), copy(),
 * component1(), component2(), ..., for all properties
 */
data class Customer(val name: String, val email: String)

// default values for function parameters
fun foo(a: Int = 0, b: String = "") {
    // ...
}