package scopeFunctions

import newLine

/**
 * Like let, run is another scoping function from the standard library. Basically, it
 * does the same: executes a code block and returns its result. The difference is that
 * inside run the object is accessed by this. This is useful when you want to call
 * the object's methods rather than pass it as an argument.
 */
fun main() {
    getNullableLength(null)
    "" newLine ""

    getNullableLength("")
    "" newLine ""

    getNullableLength("some string with Kotlin")
    "" newLine ""
}

fun getNullableLength(text: String?) {
    println("for \"$text\":")

    text?.run {
        println("\tis empty? " + isEmpty())
        println("\tlength = $length")
        this.length
    }
}