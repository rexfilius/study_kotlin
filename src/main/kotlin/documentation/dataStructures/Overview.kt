package documentation.dataStructures

/**
 * The following collection types are relevant for Kotlin:
 * 1. LIST: an ordered collection with access to elements by indices (integer numbers that
 *    reflect their position). Elements can occur more than once in a list. An example of
 *    a list is a sentence: it's a group of words, their order is important, and they can
 *    repeat.
 * 2. SET: a collection of unique elements. It reflects the mathematical abstraction of
 *    set (a group of objects without repetitions). Generally, the order of set elements
 *    has no significance. For example, an alphabet is a set of letters.
 * 3. MAP or DICTIONARY: a set of key-value pairs. Keys are unique, and each of them maps
 *    to exactly one value. The values can be duplicates. Maps are useful for storing
 *    logical connections between objects, e.g., an employee's ID and their position
 */

/**
 * Kotlin lets you manipulate collections independently of the exact type of objects
 * stored in them. In other words, you add a String to a list of String s the same way
 * as you would do with Int s or a user-defined class. So, the Kotlin Standard Library
 * offers generic interfaces, classes, and functions for creating, populating,
 * and managing collections of any type
 */

fun main() {

    /**
     * The Kotlin Standard Library provides implementations for basic collection types:
     * sets, lists, and maps. A pair of interfaces represent each collection type:
     * 1. A read-only interface that provides operations for accessing collection elements
     * 2. A mutable interface that extends the corresponding read-only interface with
     *    write operations: adding, removing, and updating its elements.
     * NB: altering a mutable collection doesn't require it to be a var: write operations
     *     modify the same mutable collection object, so the reference doesn't change.
     *     Although, if you try to reassign a val collection, you get compilation error
     */
    val numbers = mutableListOf("one", "two", "three", "four")
    numbers.add("five")    // this is OK
    //numbers = mutableListOf("six", "seven")    // compilation error

    /**
     * The read-only collection types are covariant. This means that, if a Rectangle class
     * inherits from Shape, you can use a List<Rectangle> anywhere the List<Shape> is
     * required. In other words, the collection types have the same subtyping relationship
     * as the element types. Maps are covariant on the value type, but not on the key type.
     * In turn, mutable collections aren't covariant; otherwise, this would lead to runtime
     * failures. If MutableList<Rectangle> was a subtype of MutableList<Shape>, you could
     * insert other Shape inheritors (e.g, Circle) into it,
     * thus violating its Rectangle type argument
     */
}

/**
 * KOTLIN COLLECTION INTERFACES
 * ...
 * MutableList (isA) List (isA) Collection (isA) Iterable
 * MutableSet (isA) Set (isA) Collection (isA) Iterable
 * MutableMap (isA) Map [stand-alone]
 * ...
 * MutableList (isA) MutableCollection (isA) MutableIterable
 * MutableSet (isA) MutableCollection (isA) MutableIterable
 * ...
 * MutableCollection (isA) Collection
 * MutableIterable (isA) Iterable
 */





