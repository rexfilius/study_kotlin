package collections

import newLine

fun main() {

    /**
     * filter::
     * enables you to filter collections. It takes a filter predicate as
     * a lambda-parameter. The predicate is applied to each element. Elements that make
     * the predicate true are returned in the result collection.
     */
    val aNumbers = listOf(1, -2, 3, -4, 5, -6)
    println("numbers: $aNumbers")
    println("positives: " + aNumbers.filter { x -> x > 0 })
    println("negatives: " + aNumbers.filter { it < 0 })
    "" newLine ""

    /**
     * map::
     * enables you to apply a transformation to all elements in a
     * collection. It takes a transformer function as a lambda-parameter.
     */
    val bNumbers = listOf(1, -2, 3, -4, 5, -6)
    println("numbers: $bNumbers")
    println("doubled: " + bNumbers.map { x -> x * 2 })
    println("tripled: " + bNumbers.map { it * 3 })
    "" newLine ""

    /**
     * any, all, none::
     * These functions check the existence of collection elements that match a given predicate.
     * - any returns true if the collection contains at least one element that matches the given predicate.
     * - all returns true if all elements in collection match the given predicate.
     * - none returns true if there are no elements that match the given predicate in the collection.
     */
    val cNumbers = listOf(1, -2, 3, -4, 5, -6)
    println("numbers: $cNumbers")
    println("anyNegative: " + cNumbers.any { it < 0 })
    println("anyGreaterThanSix: " + cNumbers.any { it > 6 })
    "" newLine ""

    val dNumbers = listOf(1, -2, 3, -4, 5, -6)
    println("numbers: $dNumbers")
    println("allEven: " + dNumbers.all { it % 2 == 0 })
    println("allLessThanSix: " + dNumbers.all { it < 6 })
    "" newLine ""

    val eNumbers = listOf(1, -2, 3, -4, 5, -6)
    println("numbers: $eNumbers")
    println("allEven: " + eNumbers.none { it % 2 == 1 })
    println("allLessThanSix: " + eNumbers.none { it > 6 })
    "" newLine ""

    /**
     * find, findLast::
     * find and findLast functions return the first or the last collection element that
     * matches the given predicate. If there are no such elements, functions return null.
     */
    val w = listOf("Lets", "find", "something", "in", "collection", "somehow")
    println("words: $w")
    println("first word starts with SOME: " + w.find { it.startsWith("some") })
    println("last word starts with SOME: " + w.findLast { it.startsWith("some") })
    println("first word containing NOTHING: " + w.find { it.contains("nothing") })

}
