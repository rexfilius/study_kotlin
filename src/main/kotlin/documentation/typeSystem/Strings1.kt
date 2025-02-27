package documentation.typeSystem

import newLine

fun main() {
    /*
     * Strings in Kotlin are represented by the type String. Generally, a string value is
     * a sequence of characters in double quotes (""). Elements of a string are
     * characters that you can access via the indexing operation.
     * You can iterate over these characters with a for loop.
     * -
     * NOTE: Strings are immutable. Once you initialize a string, you can't change its
     * value or assign a new value to it. All operations that transform strings return
     * their results in a new String object, leaving the original string unchanged.
     */
    val subject = "programming"
    println("$subject[index 5]: ${subject[5]}")

    for (c in subject) print("$c-")
    "" newLine "\n"

    val city = "tokyo"
    println(city.uppercase()) // Create and print a new String object
    println(city)  // the original string remains the same

    val letters = "abc" + 1
    println(letters + "def")
    "" newLine ""

    /*
     * Kotlin has two types of string literals
     * 1. escaped strings that may contain escaped characters
     * 2. raw strings that can contain newlines and arbitrary text
     * - A raw string is delimited by a triple quote(""""""), contains no escaping
     * and can contain newlines and any other characters.
     */
    val greet = "Bonjour\n"
    println(greet)

    val text = """
        for (c in "foo")
            print(c)
    """.trimIndent()
    println(text)
    "" newLine ""

    val texts = """
        |Tell me and I forget.
        |Teach me and I remember.
        |Involve me and I learn.
        |(Benjamin Franklin)
    """.trimMargin()
    println(texts)
    "" newLine ""

    /*
     * String literals may contain template expressions - pieces of code that are
     * evaluated and whose results are concatenated into the string. A template
     * expression starts with a dollar sign ($) and consists of either a name or
     * an expression in curly braces.
     */
    val i = 10
    println("i = $i")

    val name = "Johnny"
    println("$name.length is ${name.length}")

    val price = """${'$'}9.99"""
    println(price)
    println()
    "" newLine "::String Formatting"

    /*
     * String formatting with the String.format() function is only available in Kotlin/JVM.
     */
    // Formats an integer, adding leading zeroes to reach a length of seven characters
    val integerNumber = String.format("%07d", 31416)
    println(integerNumber) // 0031416

    // Formats a floating-point number to display with a + sign and four decimal places
    val floatNumber = String.format("%+.4f", 3.141592)
    println(floatNumber) // +3.1416

    // Formats two strings to uppercase, each taking one placeholder
    val helloString = String.format("%S %S", "hello", "world")
    println(helloString) // HELLO WORLD

    // Formats a negative number to be enclosed in parentheses,
    // then repeats the same number in a different format (without parentheses) using `argument_index$`.
    val negativeNumberInParentheses = String.format("%(d means %1\$d", -31416)
    println(negativeNumberInParentheses) //(31416) means -31416
}