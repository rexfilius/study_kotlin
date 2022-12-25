package dataStructures

/**
 * COLLECTION WRITE OPERATIONS:
 * Mutable collections support operations for changing the collection contents, e.g
 * adding or removing elements. For more specific operations available for List and Map,
 * see List-specific Operations and Map Specific Operations respectively
 * ...
 * UPDATING ELEMENTS:
 * Lists and maps also provide operations for updating elements. They are described in
 * List-specific Operations and Map Specific Operations. For sets, updating doesn't make
 * sense since it's actually removing an element and adding another one.
 */
fun main() {

    /**
     * ADDING ELEMENTS
     * To add a single element to a list or a set, use the add() function. The specified
     * object is appended to the end of the collection.
     * ...
     * addAll() adds every element of the argument object to a list or a set. The argument
     * can be an Iterable, a Sequence, or an Array. The types of the receiver and the
     * argument may be different, e.g. you can add all items from a Set to a List.
     * ...
     * When called on lists, addAll() adds new elements in the same order as they go in
     * the argument. You can also call addAll() specifying an element position as the
     * first argument. The first element of the argument collection will be inserted
     * at this position. Other elements of the argument collection will follow it,
     * shifting the receiver elements to the end
     */
    val aNumbers = mutableListOf(1, 2, 3, 4)
    aNumbers.add(5)
    println(aNumbers)

    val bNumbers = mutableListOf(1, 2, 5, 6)
    bNumbers.addAll(arrayOf(7, 8))
    println(bNumbers)
    bNumbers.addAll(2, setOf(3, 4))
    println(bNumbers)
    println()

    /**
     * You can also add elements using the in-place version of the plus operator -
     * plusAssign '+=' When applied to a mutable collection, '+=' appends the second
     * operand (an element or another collection) to the end of the collection
     */
    val cNumbers = mutableListOf("one", "two")
    cNumbers += "three"
    println(cNumbers)
    cNumbers += listOf("four", "five")
    println(cNumbers)
    println()

    /**
     * REMOVING ELEMENTS:
     * To remove an element from a mutable collection, use the remove() function.
     * remove() accepts the element value and removes one occurrence of this value
     */
    val dNumbers = mutableListOf(1, 2, 3, 4, 3)
    dNumbers.remove(3)    // removes the first `3`
    println(dNumbers)
    dNumbers.remove(5)    // removes nothing
    println(dNumbers)
    println()

    /**
     * Removing multiple elements at once:
     * removeAll() removes all elements that are present in the argument collection.
     * Alternatively, you can call it with a predicate as an argument; in this case
     * the function removes all elements for which the predicate yields true.
     * ...
     * retainAll() is the opposite of removeAll(): it removes all elements except the ones
     * from the argument collection. When used with a predicate, it leaves only elements
     * that match it.
     * ...
     * clear() removes all elements from a list and leaves it empty
     */
    val eNumbers = mutableListOf(1, 2, 3, 4)
    println("eNumbers: $eNumbers")
    eNumbers.retainAll { it >= 3 }
    println("retainAll{it>=3}: $eNumbers")
    eNumbers.clear()
    println("clear: $eNumbers")
    println()

    val numbersSet = mutableSetOf("one", "two", "three", "four")
    println("numbersSet: $numbersSet")
    numbersSet.removeAll(setOf("one", "two"))
    println("removeAll(setOf(one, two)): $numbersSet")
    println()

    val fNumbers = mutableListOf("one", "two", "three", "three", "four")
    fNumbers -= "three"
    println(fNumbers)
    fNumbers -= listOf("four", "five")
    //fNumbers -= listOf("four")    // does the same as above
    println(fNumbers)
}