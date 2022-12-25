package dataStructures

fun main() {

    // check if a number is within a range using 'in' operator
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    } else {
        println("does not fit in range")
    }
    println()

    // check if a number is out of range
    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }
    println()

    // iterating over a range
    for (p in 1..5) print("$p. ")
    println("\n")

    // iterating over a progression
    for (b in 1..10 step 2) print("$b. ")
    println()
    for (c in 9 downTo 0 step 3) print("$c. ")
}