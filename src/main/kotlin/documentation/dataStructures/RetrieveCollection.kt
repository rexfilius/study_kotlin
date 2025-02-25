package documentation.dataStructures

/**
 * The Kotlin standard library contains extension functions for retrieving parts of a
 * collection. These functions provide a variety of ways to select elements for the result
 * collection: listing their positions explicitly, specifying the result size, and others
 */
fun main() {

    /**
     * SLICE
     * returns a list of the collection elements with given indices. The indices may be
     * passed either as a range or as a collection of integer values
     */
    val position = listOf("one", "two", "three", "four", "five", "six", "seven")
    println(position.slice(0..3))
    println(position.slice(0..4 step 2))
    println(position.slice(setOf(3, 5, 0)))
    println()

    /**
     * TAKE & DROP
     * To get the specified number of elements starting from the first, use the take()
     * function. For getting the last elements, use takeLast(). When called with a number
     * larger than the collection size, both functions return the whole collection.
     * To take all the elements except a given number of first or last elements, call the
     * drop() and dropLast() functions respectively
     */
    val order = listOf("one", "two", "three", "four", "five", "six")
    println("order: $order")
    println("take(3): ${order.take(3)}")
    println("takeLast(3): ${order.takeLast(3)}")
    println("drop(1): ${order.drop(1)}")
    println("dropLast(2): ${order.dropLast(2)}")
    println()

    /**
     * You can also use predicates to define the number of elements for taking or dropping.
     * There are four functions similar to 'take and drop':
     * ...
     * takeWhile() is take() with a predicate: it takes the elements up to but excluding
     * the first one not matching the predicate. If the first collection element doesn't
     * match the predicate, the result is empty.
     * ...
     * takeLastWhile() is similar to takeLast(): it takes the range of elements matching
     * the predicate from the end of the collection. The first element of the range is the
     * element next to the last element not matching the predicate. If the last collection
     * element doesn't match the predicate, the result is empty
     * ...
     * dropWhile() is the opposite to takeWhile() with the same predicate: it returns the
     * elements from the first one not matching the predicate to the end.
     * ...
     * dropLastWhile() is the opposite to takeLastWhile() with the same predicate: it
     * returns the elements from the beginning to the last one not matching the predicate
     */
    val counts = listOf("one", "two", "three", "four", "five", "six")
    println("counts: $counts")
    println("takeWhile: ${counts.takeWhile { !it.startsWith('f') }}")
    println("takeLastWhile: ${counts.takeLastWhile { it != "three" }}")
    println("dropWhile: ${counts.dropWhile { it.length == 3 }}")
    println("dropLastWhile: ${counts.dropLastWhile { it.contains('i') }}")

}