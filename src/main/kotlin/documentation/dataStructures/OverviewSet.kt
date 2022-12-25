package dataStructures

fun main() {

    /**
     * Set<T> stores unique elements; their order is generally undefined. null elements
     * are unique as well: a Set can contain only one null. Two sets are equal if they
     * have the same size, and for each element of a set there is an equal element
     * in the other set
     */
    val numbers = setOf(1, 2, 3, 4)
    println("Number of elements: ${numbers.size}")
    if (numbers.contains(1)) println("1 is in the set")

    val numbersBackwards = setOf(4, 3, 2, 1)
    println("The sets are equal: ${numbers == numbersBackwards}")
    println()

    /**
     * MutableSet is a Set with write operations from MutableCollection. The default
     * implementation of Set – LinkedHashSet – preserves the order of elements insertion.
     * Hence, the functions that rely on the order, such as first() or last(), return
     * predictable results on such sets. An alternative implementation – HashSet – says
     * nothing about the elements order, so calling such functions on it returns
     * unpredictable results. However, HashSet requires less memory to store the
     * same number of elements.
     */
    val n = setOf(1, 2, 3, 4)  // LinkedHashSet is the default implementation
    val nBack = setOf(4, 3, 2, 1)

    println(n.first() == nBack.first())
    println(n.first() == nBack.last())

}
