package dataStructures

fun main() {

    /**
     * For traversing collection elements, the Kotlin standard library supports the
     * commonly used mechanism of iterators – objects that provide access to the elements
     * sequentially without exposing the underlying structure of the collection. Iterators
     * are useful when you need to process all the elements of a collection one-by-one,
     * e.g, print values or make similar updates to them. Iterators can be obtained for
     * inheritors of the Iterable<T> interface, including Set and List, by calling
     * the iterator() function.
     * ...
     * Once you obtain an iterator, it points to the first element of a collection; calling
     * the next() function returns this element and moves the iterator position to the
     * following element if it exists. Once the iterator passes through the last element,
     * it can no longer be used for retrieving elements; neither can it be reset
     * to any previous position
     */
    val numbers = listOf("one", "two", "three", "four")
    val numbersIterator = numbers.iterator()

    while (numbersIterator.hasNext()) {
        print("${numbersIterator.next()}..")
    }
    println()

    // Another way to go through an Iterable collection is the well-known 'for loop'
    val digits = listOf("one", "two", "three", "four")
    for (item in digits) {
        print("$item..")
    }
    println("\n")

    // a forEach() function lets you automatically iterate a collection and execute
    // the given code for each element
    val names = listOf("Jane", "John", "Mary")
    names.forEach { print("$it..") }
    println("\n")

    /**
     * For lists, there is a special iterator implementation: ListIterator. It supports
     * iterating lists in both directions: forwards and backwards. Backward iteration is
     * implemented by the functions hasPrevious() and previous(). Additionally, the
     * ListIterator provides information about the element indices with the functions
     * nextIndex() and previousIndex(). Having the ability to iterate in both directions,
     * means the ListIterator can still be used after it reaches the last element.
     */
    val cities = listOf("Tokyo", "Moscow", "Durban", "Rome")
    val citiesIterator = cities.listIterator()

    while (citiesIterator.hasNext()) print("${citiesIterator.next()}..")
    println("\nIterating backwards:")

    while (citiesIterator.hasPrevious()) {
        print("Index: ${citiesIterator.previousIndex()}")
        println(", Value: ${citiesIterator.previous()}")
    }
    println()

    /**
     * For iterating mutable collections, there is MutableIterator that extends Iterator
     * with the function: remove(). So, you can remove elements from a collection while
     * iterating it. In addition to removing elements, the MutableListIterator can also
     * insert and replace elements while iterating the list
     */
    val foods = mutableListOf("Rice", "Beans", "Yam", "Potato")
    val mutableIterator = foods.iterator()

    mutableIterator.next()
    mutableIterator.remove()
    println("After removal: $foods")
    println()

    val colors = mutableListOf("blue", "red", "red", "green")
    val mutableListIterator = colors.listIterator()

    mutableListIterator.next()
    mutableListIterator.add("pink")
    mutableListIterator.next()
    mutableListIterator.set("brown")
    print("$colors..")

}