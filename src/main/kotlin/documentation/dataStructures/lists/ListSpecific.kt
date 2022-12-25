package dataStructures

fun main() {

    /**
     * RETRIEVE SINGLE ELEMENTS
     * Lists support all common operations for element retrieval: elementAt(), first(),
     * last(), and others listed in [RetrieveSingle.kt] & [RetrieveSingle2.kt]. What is specific
     * for lists is index access to the elements, so the simplest way to read an element
     * is retrieving it by index. That is done with the get() function with the index
     * passed in the argument or the shorthand '[index]' syntax.
     * ...
     * If the list size is less than the specified index, an exception is thrown. There
     * are two other functions that help you avoid such exceptions:
     * getOrElse() lets you provide the function for calculating the default value to
     * return if the index isn't present in the collection.
     * getOrNull() returns null as the default value
     */
    val aNumbers = listOf(1, 2, 3, 4)
    println(aNumbers.get(0))
    println(aNumbers[0])
    //aNumbers.get(5)    // exception

    println(aNumbers.getOrNull(5))             // null
    println(aNumbers.getOrElse(5) { it })        // 5
    println()

    /**
     * RETRIEVE LIST PARTS
     * In addition to common operations for Retrieving Collection Parts, lists provide the
     * subList() function that returns a view of the specified elements range as a list.
     * Thus, if an element of the original collection changes, it also changes in the
     * previously created sublists and vice versa
     */
    val bNumbers = (0..13).toList()
    println("bNumbers: $bNumbers")
    println("subList(3,6): ${bNumbers.subList(3, 6)}")
    println()

    /**
     * Find Element Positions - LINEAR SEARCH
     * In any lists, you can find the position of an element using the functions indexOf()
     * and lastIndexOf(). They return the first and the last position of an element equal
     * to the given argument in the list. If there are no such elements, both functions
     * return -1.
     * ...
     * There is also a pair of functions that take a predicate and search for elements
     * matching it:
     * indexOfFirst() returns the index of the first element matching the predicate
     * or -1 if there are no such elements.
     * indexOfLast() returns the index of the last element matching the predicate
     * or -1 if there are no such elements
     */
    val cNumbers = listOf(1, 2, 3, 4, 2, 5)
    println(cNumbers.indexOf(2))
    println(cNumbers.lastIndexOf(2))

    val dNumbers = mutableListOf(1, 2, 3, 4)
    println(dNumbers.indexOfFirst { it > 2 })
    println(dNumbers.indexOfLast { it % 2 == 1 })
}