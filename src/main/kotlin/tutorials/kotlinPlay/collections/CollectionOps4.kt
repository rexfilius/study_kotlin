package collections

import newLine

fun main() {

    /**
     * Map Element Access::
     * When applied to a map, [] operator returns the value corresponding to the given
     * key, or null if there is no such key in the map.
     * - getValue function returns an existing value corresponding to the given key or
     * throws an exception if the key wasn't found.
     * - For maps created with withDefault, getValue returns the default value instead
     * of throwing an exception.
     */
    val map = mapOf("key" to 42)

    println("value of -key- " + map["key"])
    println("value of -key2- " + map["key2"])
    println("value of -key- " + map.getValue("key"))
    "" newLine ""

    val mapWithDefault = map.withDefault { k -> k.length }
    println(mapWithDefault.getValue("key2"))

    try {
        map.getValue("anotherKey")
    } catch (e: NoSuchElementException) {
        println("Message: $e")
    }
    "" newLine ""

    /**
     * zip::
     * merges two given collections into a new collection. By default, the result
     * collection contains Pairs of source collection elements with the same index.
     * However, you can define own structure of the result collection element. The size
     * of the result collection equals to the minimum size of a source collection.
     */
    val a = listOf("a", "b", "c")
    val b = listOf(1, 2, 3, 4)

    println(a zip b)
    println(a.zip(b) { x, y -> "$x$y" })
    "" newLine ""

    /**
     * getOrElse::
     * - provides safe access to elements of a collection. It takes an index and a
     * function that provides the default value in cases when the index is out of bound.
     * - can also be applied to Map to get the value for the given key.
     */
    val list = listOf(0, 10, 20)
    println("list $list")
    println("getOrElse -index 1- " + list.getOrElse(1) { 42 })
    println("getOrElse -index 10- " + list.getOrElse(10) { 42 })
    "" newLine ""

    val aMap = mutableMapOf<String, Int?>()
    println(aMap.getOrElse("x") { 1 })    // prints default value, key is absent

    aMap["x"] = 3
    println(aMap.getOrElse("x") { 1 })    // prints 3, value for key 'x'

    aMap["x"] = null
    println(map.getOrElse("x") { 1 })    // prints default value, undefined value

}