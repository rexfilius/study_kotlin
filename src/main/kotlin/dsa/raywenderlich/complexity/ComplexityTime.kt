package raywenderlich.complexity

/**
 * - For algorithms, SCALABILITY refers to how the algorithm performs in terms of
 * EXECUTION TIME and MEMORY USAGE as the input size increases.
 * - With a small amount of data, any algorithm may still feel fast. However, as the
 * amount of data increases, an expensive algorithm can become crippling.
 * - TIME COMPLEXITY is a measure of the time required to run an algorithm as
 * the input size increases.
 */
fun main() {

    // CONSTANT TIME
    checkFirst(listOf("Jon", "Jude"))
    checkFirst(listOf("Mane", "Jack", "Prince"))

    // LINEAR TIME
    printNames(listOf("Jenny", "Abbey", "Abdul"))
    printNames(listOf("Jon", "Jude", "Jake", "Jane", "Jill", "Jim"))
}

/**
 * - CONSTANT TIME - O(1)
 * A constant time algorithm is one that has the same running time regardless of
 * the size of the input
 * - The size of names does not affect the running time of this function. Whether
 * names has 10 items or 10 million items, this function only checks the first
 * element of the list.
 */
fun checkFirst(names: List<String>) {
    if (names.firstOrNull() != null) {
        println(names.first())
    } else {
        println("no names")
    }
}

/**
 * - LINEAR TIME - O(n)
 * in linear time, as the amount of data increases, the running time increases
 * by the same amount
 * - this function prints all the names in a String list. As the input list increases
 * in size, the number of iterations is increased by the same amount
 */
fun printNames(names: List<String>) {
    for (name in names) {
        println(name)
    }
}

/**
 * NOTE: What about a function that has two loops over all the data and calls six
 * different O(1) methods? Is it O(2n + 6) ?
 * Time complexity only gives a high-level shape of the performance. Loops that happen
 * a set number of times are not part of the calculation. You'll need to abstract
 * everything and consider only the most important thing that affects performance.
 * All constants are dropped in the final Big O notation
 * i.e. O(2n + 6) is surprisingly equal to O(n)
 */
