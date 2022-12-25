package dataStructures

/**
 * The sequence operations can be classified into two regarding their state requirements:
 * 1. Stateless operations require no state and process each element independently, e.g,
 *    map() or filter(). Stateless operations can also require a small constant amount
 *    of state to process an element, e.g., take() or drop().
 * 2. Stateful operations require a significant amount of state, usually proportional to
 *    the number of elements in a sequence.
 * ...
 * If a sequence operation returns another sequence, which is produced lazily, it's called
 * intermediate. Otherwise, the operation is terminal. Examples of terminal operations
 * are toList() or sum(). Sequence elements can be retrieved only with terminal operations.
 * Sequences can be iterated multiple times; however some sequence implementations might
 * constrain themselves to be iterated only once.
 */
fun main() {

    // DIFFERENCE BTW Iterable & Sequence
    // sequence: 18 steps ... iterable: 23 steps

    // ITERABLE
    val words = "The quick brown fox jumps over the lazy dog".split(" ")
    val lengthsList = words.filter { println("filter: $it"); it.length > 3 }
            .map { println("length: ${it.length}"); it.length }
            .take(4)

    println("Lengths of first 4 words longer than 3 chars:")
    println(lengthsList)
    println()

    // SEQUENCE
    val word = "The quick brown fox jumps over the lazy dog".split(" ")
    val wordsSequence = words.asSequence()

    val lengthsSequence =
            wordsSequence.filter { println("filter: $it"); it.length > 3 }
                    .map { println("length: ${it.length}"); it.length }
                    .take(4)

    println("Lengths of first 4 words longer than 3 chars:")
    // terminal operation: obtaining the result as a List
    println(lengthsSequence.toList())
}