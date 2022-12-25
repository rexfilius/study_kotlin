package collections

import newLine
import kotlin.math.abs

fun main() {

    /**
     * partition::
     * splits the original collection into a pair of lists using a given predicate:
     * Elements for which the predicate is true. Elements for which the predicate is false.
     */
    val aNumbers = listOf(1, -2, 3, -4, 5, -6)
    println("numbers: $aNumbers")
    println("even & odd: " + aNumbers.partition { it % 2 == 0 })

    val (positives, negatives) = aNumbers.partition { it > 0 }   // Pair destructuring
    println("positives & negatives: $positives $negatives")
    "" newLine ""

    /**
     * flatMap::
     * transforms each element of a collection into an iterable object and builds a
     * single list of the transformation results. The transformation is user-defined.
     */
    val fruitsBag = listOf("apple", "orange", "banana", "grapes")
    val clothesBag = listOf("shirts", "pants", "jeans")
    val cart = listOf(fruitsBag, clothesBag)

    println("map: " + cart.map { it })
    println("flatten: " + cart.flatten())    // SAME AS: cart.flatMap { it }
    "" newLine ""

    /**
     * minOrNull, maxOrNull::
     * return the smallest and the largest element of a collection. If the collection
     * is empty, they return null.
     */
    val num = listOf(1, 2, 3)
    val empty = emptyList<Int>()
    val only = listOf(3)

    println("Numbers: $num, min: ${num.minOrNull()}, max: ${num.maxOrNull()}")
    println("Empty: $empty, min = ${empty.minOrNull()}, max = ${empty.maxOrNull()}")
    println("Only: $only, min = ${only.minOrNull()}, max = ${only.maxOrNull()}")
    "" newLine ""

    /**
     * sorted returns a list of collection elements sorted according to their natural
     * sort order (ascending).
     * sortedBy sorts elements according to natural sort order of the values returned by
     * specified selector function.
     */
    val shuffled = listOf(5, 4, 2, 1, 3, -10)
    println("list: $shuffled")
    println("natural order: " + shuffled.sorted())
    println("inverted order: " + shuffled.sortedBy { -it })
    println("descending order: " + shuffled.sortedDescending())
    println("descendingBy abs(it): " + shuffled.sortedByDescending { abs(it) })
    "" newLine ""


}