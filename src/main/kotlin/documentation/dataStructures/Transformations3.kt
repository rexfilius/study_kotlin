package documentation.dataStructures

import newLine

fun main() {

    /**
     * If you operate nested collections, you may find the standard library functions that
     * provide flat access to nested collection elements useful. The first function is
     * flatten(). You can call it on a collection of collections, e.g, a List of Set.
     * The function returns a single List of all the elements of the nested collections
     */
    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    println(numberSets.flatten())
    "" newLine ""

    /**
     * Another function: flatMap() provides a flexible way to process nested collections.
     * It takes a function that maps a collection element to another collection. As a
     * result, flatMap() returns a single list of its return values on all the elements.
     * So, flatMap() behaves as a subsequent call of map() (with a collection as a mapping
     * result) and flatten()
     */
    val containers = listOf(
        StringContainer(listOf("one", "two", "three")),
        StringContainer(listOf("four", "five", "six")),
        StringContainer(listOf("seven", "eight"))
    )
    println(containers.flatMap { it.values })
    "" newLine ""

    /**
     * If you need to retrieve the collection content in a readable format, use functions
     * that transform the collections to strings: joinToString() and joinTo().
     * joinToString() builds a single String from the collection elements based on the
     * provided arguments. joinTo() does the same but appends the result to the given
     * Appendable object. When called with the default arguments, the functions return the
     * result similar to calling toString() on the collection
     */
    val numbers = listOf("one", "two", "three", "four")
    println(numbers)
    println(numbers.joinToString())

    val listString = StringBuffer("The list of numbers: ")
    numbers.joinTo(listString)
    println(listString)
    println()

    /**
     * To build a custom string representation, you can specify its parameters in function
     * arguments separator, prefix, and postfix. The resulting string will start with the
     * prefix and end with the postfix.
     * The separator will come after each element except the last
     */
    val position = listOf("1st", "2nd", "3rd", "4th", "5th")
    println(
        position.joinToString(
            separator = " | ",
            prefix = "start: ",
            postfix = ": end"
        )
    )
    println()

    /**
     * For bigger collections, you may want to specify the limit – a number of elements that
     * will be included into result. If the collection size exceeds the limit, all the other
     * elements will be replaced with a single value of the truncated argument
     */
    val digits = (1..100).toList()
    print(digits.joinToString(limit = 20, truncated = "<...>"))
    println("\n")

    // To customize the representation of elements themselves,
    // provide the transform function
    val words = listOf("Bag", "Run", "Sand", "Cruise")
    println(words.joinToString { "Element: ${it.uppercase()}" })

}

class StringContainer(container: List<String>) {
    val values = container
}