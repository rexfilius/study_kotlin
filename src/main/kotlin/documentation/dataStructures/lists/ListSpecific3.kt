package dataStructures

/**
 * In addition to the collection modification operations described in Collection write
 * operations [WriteOp.kt], mutable lists support specific write operations. Such
 * operations use the index to access elements to broaden the list modification capabilities.
 */
fun main() {

    /**
     * ADD
     * To add elements to a specific position in a list, use add() and addAll() providing
     * the position for element insertion as an additional argument. All elements that
     * come after the position shift to the right
     */
    val aNumbers = mutableListOf("one", "five", "six")
    aNumbers.add(1, "two")
    aNumbers.addAll(2, listOf("three", "four"))
    println(aNumbers)
    println()

    /**
     * UPDATE
     * Lists also offer a function to replace an element at a given position: set() and
     * its operator form '[]'. set() doesn't change the indexes of other elements.
     * fill() simply replaces all the collection elements with the specified value
     */
    val bNumbers = mutableListOf("one", "five", "three")
    bNumbers[1] = "two"
    println(bNumbers)

    val cNumbers = mutableListOf(1, 2, 3, 4)
    cNumbers.fill(3)
    println(cNumbers)
    println()

    /**
     * REMOVE
     * To remove an element at a specific position from a list, use the removeAt() function
     * providing the position as an argument. All indices of elements that come after
     * the element being removed will decrease by one.
     */
    val dNumbers = mutableListOf(1, 2, 3, 4, 3)
    dNumbers.removeAt(1)
    println(dNumbers)
    println()

    /**
     * SORT
     * In [Ordering.kt] & [Ordering2.kt], we describe operations that retrieve collection
     * elements in specific orders. For mutable lists, the standard library offers similar
     * extension functions that perform the same ordering operations in place. When you
     * apply such an operation to a list instance, it changes the order of elements in
     * that exact instance. The in-place sorting functions have similar names to the
     * functions that apply to read-only lists, but without the ed/d suffix:
     * ...
     * sort* instead of sorted* in the names of all sorting functions:
     * sort(), sortDescending(), sortBy(), and so on.
     * shuffle() instead of shuffled().
     * reverse() instead of reversed().
     * ...
     * asReversed() called on a mutable list returns another mutable list which is a
     * reversed view of the original list. Changes in that view are reflected in the
     * original list.
     */
    val numbers = mutableListOf("one", "two", "three", "four")
    println("numbers: $numbers")

    numbers.sort()
    println("Sort into ascending: $numbers")
    numbers.sortDescending()
    println("Sort into descending: $numbers")

    numbers.sortBy { it.length }
    println("Sort into ascending by length: $numbers")
    numbers.sortByDescending { it.last() }
    println("Sort into descending by the last letter: $numbers")

    numbers.sortWith(compareBy<String> { it.length }.thenBy { it })
    println("Sort by Comparator: $numbers")

    numbers.shuffle()
    println("Shuffle: $numbers")

    numbers.reverse()
    println("Reverse: $numbers")

}