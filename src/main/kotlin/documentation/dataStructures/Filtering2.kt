package dataStructures

fun main() {

    /**
     * Another filtering function – partition() – filters a collection by a predicate and
     * keeps the elements that don't match it in a separate list. So, you have a Pair of
     * List as a return value: the first list containing elements that match the predicate
     * and the second one containing everything else from the original collection
     */
    val numbers = listOf("one", "two", "three", "four")
    val (match, rest) = numbers.partition { it.length > 3 }

    println(match)
    println(rest)
    println()

    /**
     * There are functions that simply test a predicate against collection elements:
     * any() returns true if at least one element matches the given predicate.
     * none() returns true if none of the elements match the given predicate.
     * all() returns true if all elements match the given predicate. Note that all()
     * returns true when called with any valid predicate on an empty collection.
     * Such behavior is known in logic as vacuous truth
     */
    val s = listOf("one", "two", "three", "four")

    println(s.any { it.endsWith("e") })
    println(s.none { it.endsWith("a") })
    println(s.all { it.endsWith("e") })

    println(emptyList<Int>().all { it > 5 })   // vacuous truth
    println()

    /**
     * any() and none() can also be used without a predicate: in this case they just check
     * the collection emptiness. any() returns true if there are elements and false if
     * there aren't; none() does the opposite
     */
    val slot = listOf("one", "two", "three", "four")
    val empty = emptyList<String>()

    println(slot.any())
    println(empty.any())

    println(slot.none())
    println(empty.none())
}