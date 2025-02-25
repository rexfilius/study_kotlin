package documentation.dataStructures

import java.util.*
import kotlin.collections.HashSet

fun main() {

    /**
     * The most common way to create a collection is with the standard library functions
     * listOf<T>(), setOf<T>(), mutableListOf<T>(), mutableSetOf<T>(). If you provide a
     * comma-separated list of collection elements as arguments, the compiler detects the
     * element type automatically. When creating empty collections,
     * specify the type explicitly
     */
    val numberSet = setOf("One", "two", "three")
    val emptySet = mutableSetOf<String>()

    /**
     * The same is available for maps with the functions mapOf() and mutableMapOf().
     * The map's keys and values are passed as Pair objects
     * (usually created with to infix function)
     */
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)

    /**
     * NOTE: 'to' notation creates a short-living Pair object, so it's recommended that you
     * use it only if performance isn't critical. To avoid excessive memory usage, use
     * alternative ways. e.g. you can create a mutable map and populate it using the write
     * operations. The apply() function can help to keep the initialization fluent here
     */
    val nMap = mutableMapOf<String, String>().apply {
        this["one"] = "1"; this["two"] = "2"
    }

    /**
     * There are also functions for creating collections without any elements: emptyList(),
     * emptySet(), and emptyMap(). When creating empty collections, you should specify
     * the type of elements that the collection will hold
     */
    val empty = emptyList<String>()

    // For Lists, there's a constructor that takes the list size and the initializer
    // function that defines the element value based on its index
    val doubled = List(3) { it * 2 }
    println(doubled)

    /**
     * To create a concrete type collection, such as an ArrayList or LinkedList, you can
     * use the available constructors for these types. Similar constructors are available
     * for implementations of Set and Map
     */
    val linkedList = LinkedList<String>(listOf("one", "two", "three"))
    val presizedSet = HashSet<Int>(32)

}