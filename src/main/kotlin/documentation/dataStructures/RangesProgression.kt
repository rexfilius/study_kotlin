package dataStructures

import getAnInt

fun main() {

    /**
     * Kotlin lets you easily create ranges of values using the rangeTo() function from
     * the [kotlin.ranges] package and its operator form '..' Usually, rangeTo() is
     * complemented by 'in' or '!in' functions.
     */
    val i = getAnInt()
    // equivalent of 1 <= i && i <= 4
    if (i in 1..4) print("$i")
    println()

    /**
     * Integral type ranges (IntRange, LongRange, CharRange) have an extra feature: they
     * can be iterated over. These ranges are also progressions of the corresponding
     * integral types. Such ranges are generally used for iteration in the for loops
     */
    for (y in 1..5) print("$y..")
    println()

    // to iterate numbers in reverse order, use downTo() instead of '..'
    for (alp in 'Z' downTo 'P') print("$alp..")
    println()

    // it is also possible to iterate over numbers with an arbitrary step
    // (not necessarily 1). this is done via the 'step' function.
    for (d in 1..8 step 2) print("$d..")
    println()
    for (e in 8 downTo 1 step 2) print("$e")
    println()

    // to iterate a number range which doesn't include its end element, use 'until'
    for (t in 1 until 20) print("$t..")
    println()


}