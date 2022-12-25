package dataStructures

fun main() {

    // Collections can be created in result of various operations on other collections.
    // e.g filtering a list creates a new list of elements that match the filter
    val numbers = listOf("one", "two", "three", "four")
    val longerThan3 = numbers.filter { it.length > 3 }
    println(longerThan3)
    println()

    // Mapping produces a list of a transformation results
    val n = setOf(1, 2, 3)
    println(n.map { it * 3 })
    println(n.mapIndexed { idx, value -> value * idx })
    println()

    // Association produces maps
    val num = listOf("one", "two", "three", "four")
    println(num.associateWith { it.length })
}