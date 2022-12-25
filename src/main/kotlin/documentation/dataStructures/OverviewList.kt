package dataStructures

fun main() {

    /**
     * List<T> stores elements in a specified order and provides indexed access to them.
     * Indices start from zero (the index of the first element) and go to lastIndex
     * which is the (list.size - 1)
     */
    val numbers = listOf("one", "two", "three", "four")
    println("Number of elements: ${numbers.size}")
    println("Third element: ${numbers[2]}")
    println("Fourth element: ${numbers[3]}")
    println("Index of element \"two\" ${numbers.indexOf("two")}")
    println()

    /**
     * List elements (including nulls) can duplicate: a list can contain any number of
     * equal objects or occurrences of a single object. Two lists are considered equal
     * if they have the same sizes and structurally equal elements at the same positions
     */
    val bob = PersonL("Bob", 31)
    val list1 = listOf(PersonL("Adam", 20), bob, bob)
    val list2 = listOf(PersonL("Adam", 20), PersonL("Bob", 31), bob)
    println(list1 == list2)    // true
    bob.age = 32
    println(list1 == list2)    // true
    println()

    // MutableList<T> is a List with list-specific write operations,
    // for example, to add or remove an element at a specific position.
    val digits = mutableListOf(1, 2, 3, 4)
    digits.add(5)  // 1 2 3 4 5
    digits.removeAt(1)  // 1 3 4 5
    digits[0] = 0  // 0 3 4 5
    digits.shuffle()
    println(digits)
}

/**
 * ONE IMPORTANT DIFFERENCE BETWEEN LISTS && ARRAYS
 * An array's size is defined upon initialization and is never changed; in turn, a list
 * doesn't have a predefined size; a list's size can be changed as a result of write
 * operations: adding, updating, or removing elements. In Kotlin, the default
 * implementation of List is ArrayList which you can think of as a resizable array
 */

class PersonL(var name: String, var age: Int)