package dataStructures

/**
 * Filtering is one of the most popular tasks in the collection processing. In Kotlin,
 * filtering conditions are defined by predicates - lambda functions that take a collection
 * element and return a boolean value: true means that the given element matches the
 * predicate, false means the opposite. The standard library contains a group of extension
 * functions that let you filter collections in a single call. These functions leave the
 * original collection unchanged, so they are available for both mutable and read-only
 * collections. To operate the filtering result, you should assign it to a variable or
 * chain the functions after filtering
 */
fun main() {

    /**
     * The basic filtering function is filter(). When called with a predicate, filter()
     * returns the collection elements that match it. For both List and Set, the resulting
     * collection is a List, for Map it's a Map as well
     */
    val numbers = listOf("one", "two", "three", "four")
    val longerThan3 = numbers.filter { it.length > 3 }
    println(longerThan3)

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filteredMap = numbersMap.filter { (key, value) ->
        key.endsWith("1") && value > 10
    }
    println(filteredMap)
    println()

    /**
     * The predicates in filter() can only check the values of the elements. If you want
     * to use element positions in the filter, use filterIndexed(). It takes a predicate
     * with two arguments: the index and the value of an element.
     * To filter collections by negative conditions, use filterNot(). It returns a list of
     * elements for which the predicate yields false
     */
    val n = listOf("one", "two", "three", "four")

    val filteredIdx = n.filterIndexed { index, s -> (index != 0) && (s.length < 5) }
    val filteredNot = n.filterNot { it.length <= 3 }

    println(filteredIdx)
    println(filteredNot)
    println()

    /**
     * filterIsInstance() returns collection elements of a given type. Being called on a
     * List<Any>, filterIsInstance<T>() returns a List<T>, thus allowing you to call
     * functions of the T type on its items
     */
    val nm = listOf(null, 1, "two", 3.0, "four")
    println("All String elements in upper case:")
    nm.filterIsInstance<String>().forEach { println(it.toUpperCase()) }
    println()

    /**
     * filterNotNull() returns all non-null elements. Being called on a List<T?>,
     * filterNotNull() returns a List<T: Any>, thus allowing you to treat the elements
     * as non-null objects
     */
    val b = listOf(null, "one", "two", null)
    b.filterNotNull().forEach {
        println(it.length)    // length is unavailable for nullable Strings
    }
    println()
}