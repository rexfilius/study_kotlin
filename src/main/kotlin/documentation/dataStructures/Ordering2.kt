package documentation.dataStructures

fun main() {

    /**
     * NATURAL ORDER
     * The basic functions sorted() and sortedDescending() return elements of a collection
     * sorted into ascending and descending sequence according to their natural order.
     * These functions apply to collections of Comparable elements
     */
    val numbers = listOf("one", "two", "three", "four")

    println("numbers: $numbers")
    println("Sorted ascending: ${numbers.sorted()}")
    println("Sorted descending: ${numbers.sortedDescending()}")

    /**
     * CUSTOM ORDERS
     * For sorting in custom orders or sorting non-comparable objects, there are the
     * functions sortedBy() and sortedByDescending(). They take a selector function that
     * maps collection elements to Comparable values and sort the collection in natural
     * order of that values
     */
    val sortedNumbers = numbers.sortedBy { it.length }
    println("Sorted by length ascending: $sortedNumbers")

    val sortedByLast = numbers.sortedByDescending { it.last() }
    println("Sorted by the last letter descending: $sortedByLast")

    // To define a custom order for the collection sorting, you can provide your own
    // Comparator. To do this, call the sortedWith() function passing in your Comparator.
    println("Sorted by length ascending: ${numbers.sortedWith(compareBy { it.length })}")
    println()

    /**
     * REVERSE ORDER
     * You can retrieve the collection in the reversed order using the reversed() function.
     * reversed() returns a new collection with the copies of the elements. So, if you
     * change the original collection later, this won't affect the previously obtained
     * results of reversed().
     * Another reversing function - asReversed() returns a reversed view of the same
     * collection instance, so it may be more lightweight and preferable than reversed()
     * if the original list is not going to change
     */
    val words = listOf("one", "two", "three", "four")
    println(words.reversed())   // returns a new collection
    println(words.asReversed()) // does not return a new collection
    println()

    /**
     * If the original list is mutable, all its changes reflect in its reversed views and
     * vice versa. However, if the mutability of the list is unknown or the source is not
     * a list at all, reversed() is more preferable since its result is a copy that won't
     * change in the future
     */
    val n = mutableListOf("one", "two", "three", "four")
    val rn = n.asReversed()
    println(rn)
    n.add("five")
    println(rn)
    println()

    /**
     * RANDOM ORDER
     * there's a function that returns a new List containing the collection elements in a
     * random order - shuffled(). You can call it without arguments or
     * with a Random object
     */
    val c = listOf("one", "two", "three", "four")
    println(c.shuffled())
}