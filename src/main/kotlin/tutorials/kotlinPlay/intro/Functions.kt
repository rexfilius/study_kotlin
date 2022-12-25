package intro

/**
 * A simple function that takes a parameter of type String and returns Unit (no return value)
 */
fun printMessage(message: String): Unit {
    println(message)
}

/**
 * A function that takes a second optional parameter with default value 'Info'. The return
 * type is omitted, meaning that it's actually Unit
 */
fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

/**
 * A function that returns an integer
 */
fun sum(x: Int, y: Int): Int {
    return x + y
}

/**
 * A single-expression function that returns an integer (inferred)
 */
fun multiply(x: Int, y: Int) = x * y

fun main() {
    printMessage("Hello")

    printMessageWithPrefix("Hello", "Log")
    printMessageWithPrefix("Hello")
    printMessageWithPrefix(prefix = "Log", message = "Hello")

    println(sum(1, 2))
    println(multiply(2, 4))

}