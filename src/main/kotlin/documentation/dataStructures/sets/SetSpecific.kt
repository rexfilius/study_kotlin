package documentation.dataStructures.sets

/**
 * The Kotlin collections package contains extension functions for popular operations on
 * sets: finding intersections, merging, or subtracting collections from each other.
 * ...
 * To merge two collections into one, use the union() function. It can be used in the
 * infix form 'a union b'. Note that for ordered collections the order of the operands is
 * important: in the resulting collection, the elements of the first operand go before the
 * elements of the second.
 * ...
 * To find an intersection between two collections (elements present in both of them), use
 * intersect(). To find collection elements not present in another collection, use
 * subtract(). Both these functions can be called in the infix form as well.
 * ...
 * Note that set operations are supported by List as well. However, the result of set
 * operations on lists is still a Set, so all the duplicate elements are removed.
 */
fun main() {

    val numbers = setOf("one", "two", "three")

    println(numbers union setOf("four", "five"))
    println(setOf("four", "five") union numbers)

    println(numbers intersect setOf("two", "one"))

    println(numbers subtract setOf("three", "four"))
    println(numbers subtract setOf("four", "three")) // same output

}