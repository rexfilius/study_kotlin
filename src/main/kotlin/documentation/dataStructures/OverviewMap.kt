package dataStructures

fun main() {

    /**
     * Map<K,V> is not an inheritor of the Collection interface; however, it's a Kotlin
     * collection type as well. A Map stores key-value pairs (or entries); keys are
     * unique, but different keys can be paired with equal values. The Map interface
     * provides specific functions, such as access to value by key, searching keys and
     * values, and so on. Two maps containing the equal pairs are equal regardless
     * of the pair order.
     */
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)
    val anotherMap = mapOf("key2" to 2, "key1" to 1, "key4" to 1, "key3" to 3)

    println("All keys: ${numbersMap.keys}")
    println("All values: ${numbersMap.values}")

    if ("key2" in numbersMap) println("Value by key \"key2\": ${numbersMap["key2"]}")
    if (1 in numbersMap.values) println("The value 1 is in the map")
    if (numbersMap.containsValue(1)) println("The value 1 is in the map") // same as above
    println("The maps are equal: ${numbersMap == anotherMap}")
    println()

    /**
     * MutableMap is a Map with map write operations, e.g., you can add a new key-value
     * pair or update the value associated with the given key. The default implementation
     * of Map – LinkedHashMap – preserves the order of elements insertion when iterating
     * the map. In turn, an alternative implementation – HashMap – says nothing about
     * the elements order.
     */
    val nMap = mutableMapOf("one" to 1, "two" to 2)
    nMap["three"] = 3  // nMap.put("three", 3)
    nMap["one"] = 11

    println(nMap)
}