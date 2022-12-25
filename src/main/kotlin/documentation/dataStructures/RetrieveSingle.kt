package dataStructures

/**
 * RETRIEVE SINGLE ELEMENTS
 * Kotlin collections provide a set of functions for retrieving single elements from
 * collections, these functions apply to both lists and sets. A List is an ordered
 * collection. Hence, every element of a list has its position that you can use for
 * referring. Lists also offer a wider set of ways to retrieve and search for elements by
 * indices.
 * A Set is not an ordered collection by definition. However, the Kotlin Set stores
 * elements in certain orders. These can be the order of insertion (in LinkedHashSet ),
 * natural sorting order (in SortedSet ), or another order. The order of a set of elements
 * can also be unknown. In such cases, the elements are still ordered somehow, so the
 * functions that rely on the element positions still return their results. However, such
 * results are unpredictable to the caller unless they know the specific implementation of
 * Set used
 */
fun main() {

    /**
     * RETRIEVE BY POSITION
     * For retrieving an element at a specific position, there is the function elementAt()
     * elementAt() is useful for collections that don't provide indexed access, or aren't
     * statically known to provide one. In case of List, it's more idiomatic to use
     * indexed access operator - get() OR []
     */
    val numbers = linkedSetOf("one", "two", "three", "four", "five")
    println(numbers.elementAt(3))

    val numbersSortedSet = sortedSetOf("one", "two", "three", "four")
    println(numbersSortedSet.elementAt(0)) // stored in ascending order

    /**
     * There are also useful aliases for retrieving the first and last
     * element of the collection
     */
    val position = listOf("one", "two", "three", "four", "five")
    println(position.first())
    println(position.last())
    println()

    /**
     * To avoid exceptions when retrieving element with non-existing positions, use safe
     * variations of elementAt():
     * elementAtOrNull() returns null when the specified position is out of the collection
     * bounds.
     * elementAtOrElse() additionally takes a lambda function that maps an Int argument to
     * an instance of the collection element type. When called with an out-of-bounds
     * position, it returns the result of the lambda on the given value
     */
    val num = listOf("one", "two", "three", "four", "five")
    println(num.elementAtOrNull(5))
    println(num.elementAtOrElse(5) { index -> "The value for $index is undefined" })
    println()

    /**
     * RETRIEVE BY CONDITION
     * Functions first() and last() also let you search a collection for elements matching
     * a given predicate. When you call first() with a predicate that tests a collection
     * element, you'll receive the first element on which the predicate yields true. In
     * turn, last() with a predicate returns the last element matching it. If no elements
     * match the predicate, both functions throw exceptions. To avoid them, use firstOrNull()
     * and lastOrNull() instead: they return null if no matching elements are found.
     * Alternatively, you can use the aliases if their names suit your situation better:
     * find() instead of firstOrNull().
     * findLast() instead of lastOrNull().
     */
    val codes = listOf("one", "two", "three", "four", "five", "six")
    println(codes.first { it.length > 3 })
    println(codes.last { it.startsWith("f") })
    println(codes.firstOrNull { it.length > 6 })
    println()

    val dig = listOf(1, 2, 3, 4)
    println(dig.find { it % 2 == 0 })
    println(dig.findLast { it % 2 == 0 })

}