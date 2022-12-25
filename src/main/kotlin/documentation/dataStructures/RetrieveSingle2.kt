package dataStructures

fun main() {

    /**
     * RANDOM ELEMENT
     * If you need to retrieve an arbitrary element of a collection, call the random()
     * function. You can call it without arguments or with a Random object as a source of
     * the randomness. On empty collections, random() throws an exception. To receive null
     * instead, use randomOrNull()
     */
    val numbers = listOf(1, 2, 3, 4)
    println(numbers.random())
    println()

    /**
     * CHECK ELEMENT EXISTENCE
     * To check the presence of an element in a collection, use the contains() function.
     * It returns true if there's a collection element that equals() the function argument.
     * You can call contains() in the operator form with the `in` keyword. To check the
     * presence of multiple instances together at once, call containsAll() with a
     * collection of these instances as an argument. Additionally, you can check if the
     * collection contains any elements by calling isEmpty() or isNotEmpty()
     */
    val digits = listOf("one", "two", "three", "four", "five", "six")
    println(digits.contains("four"))
    println("zero" in digits)

    println(digits.containsAll(listOf("four", "two")))
    println(digits.containsAll(listOf("one", "zero")))
    println()

    val names = listOf("Jon", "Jude", "Jane", "Jack", "Janet")
    println(names.isEmpty())
    println(names.isNotEmpty())

    val empty = emptyList<String>()
    println(empty.isEmpty())
    println(empty.isNotEmpty())

}