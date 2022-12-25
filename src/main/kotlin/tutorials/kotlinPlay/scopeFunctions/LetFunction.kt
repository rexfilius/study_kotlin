package scopeFunctions

import newLine

/**
 * The Kotlin standard library function let can be used for scoping and null-checks.
 * When called on an object, let executes the given block of code and returns the result
 * of its last expression. The object is accessible inside the block by the reference it.
 */
fun main() {

    val empty = "test".let {               // 1
        customPrint(it)                    // 2
        it.isEmpty()                       // 3
    }
    println("is empty: $empty")
    "" newLine ""

    printNonNull(null)
    printNonNull("my string")

}

fun printNonNull(str: String?) {
    println("Printing \"$str\":")

    // Uses safe call: let and its code block will be executed only on non-null values.
    str?.let {
        print("\t")
        customPrint(it)
        println()
    }
}

fun customPrint(s: String) = println("**$s**")
