package documentation.functions

import getAStringNull

// Technically, scope functions are interchangeable in many cases.
fun main() {

    /**
     * LET
     * The context object is available as an argument (it ).
     * The return value is the lambda result.
     * let can be used to invoke one or more functions on results of call chains.
     */
    val aNumbers = mutableListOf("one", "two", "three", "four", "five")
    val resultList = aNumbers.map { it.length }.filter { it > 3 }
    println(resultList)

    /**
     * with let, you can rewrite the above. And If the code block contains a single
     * function with it as an argument, you can use the method reference (::)
     * instead of the lambda:
     */
    val bNumbers = mutableListOf("one", "two", "three", "four", "five")
    bNumbers.map { it.length }.filter { it > 3 }.let {
        println(it)
        // and more function calls if needed
    }

    val cNumbers = mutableListOf("one", "two", "three", "four", "five")
    cNumbers.map { it.length }.filter { it > 3 }.let(::println)
    println()

    /**
     * let is often used for executing a code block only with non-null values. To perform
     * actions on a non-null object, use the safe call operator ?. on it and call let with
     * the actions in its lambda
     */
    val word: String? = getAStringNull()
    //processNonNullString(str)       // compilation error: str can be null
    val length = word?.let {
        println("let() called on $it")
        processNonNullString(it)      // OK: 'it' is not null inside '?.let { }'
        it.length
    }
    println("length of word: $length \n")

    /**
     * Another case for using let is introducing local variables with a limited scope for
     * improving code readability. To define a new variable for the context object,
     * provide its name as the lambda argument so that it can be used instead of the
     * default it
     */
    val dNumbers = listOf("seventy","one", "two", "three", "four")
    val modifiedFirstItem = dNumbers.first().let { firstItem ->
        println("The first item of the list is '$firstItem'")
        if (firstItem.length >= 5) firstItem else "!$firstItem!"
    }.uppercase()
    println("First item after modifications: '$modifiedFirstItem'")

}

fun processNonNullString(s: String) {
    println("processing $s because it is now non-null")
}