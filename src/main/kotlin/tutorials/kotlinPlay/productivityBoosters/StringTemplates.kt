package productivityBoosters

/**
 * String templates allow you to include variable references and expressions into strings.
 * When the value of a string is requested (for example, by println), all references
 * and expressions are substituted with actual values.
 */
fun main() {

    val greeting = "Kotliner"

    println("Hello $greeting")
    println("Hello ${greeting.toUpperCase()}")

}