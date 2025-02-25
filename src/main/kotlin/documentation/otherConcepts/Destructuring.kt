package documentation.otherConcepts

// Returning two values from a function
data class Result(val result: Int, val status: String)

fun function(): Result = Result(result = 1, status = "OK")

fun main() {

    // using the function
    val (result, status) = function()

    // Destructuring declarations and maps
    val mapCities = mapOf(
            "Tokyo" to "Japan",
            "Sydney" to "Australia",
            "Moscow" to "Russia",
            "Beijing" to "China",
            "Dubai" to "UAE")
    for ((key, value) in mapCities) {
        println("$key is a city in $value")
    }
    println()

    // If you don't need a variable in the destructuring declaration, you can place an
    // underscore instead of its name.
    for ((_, value) in mapCities) {
        print("$value..")
    }
    println()

    /**
     * You can use the destructuring declarations syntax for lambda parameters. If a
     * lambda has a parameter of the Pair type (or Map.Entry, or any other type that has
     * the appropriate componentN functions), you can introduce several new parameters
     * instead of one by putting them in parentheses
     */
    // map.mapValues { entry -> "${entry.value}!" }
    // map.mapValues { (key, value) -> "$value!" }

    // NOTE the difference between declaring two parameters and declaring
    // a destructuring pair instead of a parameter
    /*
    { a -> ... } // one parameter
    { a, b -> ... } // two parameters
    { (a, b) -> ... } // a destructured pair
    { (a, b), c -> ... } // a destructured pair and another parameter
    */

}