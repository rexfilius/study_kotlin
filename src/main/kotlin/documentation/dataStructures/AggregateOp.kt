package documentation.dataStructures

/**
 * Kotlin collections contain functions for commonly used aggregate operations –
 * operations that return a single value based on the collection content. Most of them
 * are well known and work the same way as they do in other languages:
 * ...
 * minOrNull() and maxOrNull() return the smallest and the largest element respectively.
 * On empty collections, they return null.
 * average() returns the average value of elements in the collection of numbers.
 * sum() returns the sum of elements in the collection of numbers.
 * count() returns the number of elements in a collection
 */
fun main() {

    val numbers = listOf(6, 42, 10, 4)

    println("numbers: $numbers")
    println("count: ${numbers.count()}")
    println("max: ${numbers.maxOrNull()}")
    println("min: ${numbers.minOrNull()}")
    println("average: ${numbers.average()}")
    println("sum: ${numbers.sum()}")
    println()

    /**
     * There are also functions for retrieving the smallest and the largest elements by
     * certain selector function or custom Comparator:
     * maxByOrNull() and minByOrNull() take a selector function and return the element
     * for which it returns the largest or the smallest value.
     * maxWithOrNull() and minWithOrNull() take a Comparator object and return the largest
     * or smallest element according to that Comparator.
     * ...
     * These functions return null on empty collections. There are also alternatives for
     * maxByOrNull() and minByOrNull(): maxOf() and minOf(), which do the same but throw
     * a NoSuchElementException on empty collections
     */
    val digits = listOf(5, 42, 10, 4)
    val min3Remainder = digits.minByOrNull { it % 3 }
    println(min3Remainder)

    val strings = listOf("one", "two", "three", "four")
    val longestString = strings.maxWithOrNull(compareBy { it.length })
    println(longestString)
    println()

    /**
     * Besides regular sum(), there is an advanced summation function sumOf() that takes
     * a selector function and returns the sum of its application to all collection
     * elements. Selector can return different numeric types: Int, Long, Double, UInt,
     * and ULong (also BigInteger and BigDecimal on the JVM)
     */
    val code = listOf(5, 42, 10, 4)

    println(code.sumOf { it * 2 })
    println(code.sumOf { it.toDouble() / 2 })

}