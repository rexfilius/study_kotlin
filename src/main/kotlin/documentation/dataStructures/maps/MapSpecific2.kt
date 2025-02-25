package documentation.dataStructures.maps

/**
 * Mutable maps offer map-specific write operations. These operations let you change the
 * map content using the key-based access to the values.
 * There are certain rules that define write operations on maps:
 * ...
 * [1] Values can be updated. In turn, keys never change: once you add an entry,
 * its key is constant.
 * [2] For each key, there is always a single value associated with it. You can add
 * and remove whole entries.
 */
fun main() {

    /**
     * To add a new key-value pair to a mutable map, use put(). When a new entry is put
     * into a LinkedHashMap (the default map implementation), it is added so that it comes
     * last when iterating the map. In sorted maps, the positions of new elements
     * are defined by the order of their keys.
     * ...
     * To add multiple entries at a time, use putAll(). Its argument can be a Map or a
     * group of Pair's: Iterable, Sequence, or Array.
     * ...
     * Both put() and putAll() overwrite the values if the given keys already exist in the
     * map. Thus, you can use them to update values of map entries.
     */
    val aNumbersMap = mutableMapOf("one" to 1, "two" to 2)
    aNumbersMap.put("three", 3)
    println("aNumbersMap: $aNumbersMap")

    val bNumbersMap = mutableMapOf("one" to 1, "two" to 2, "three" to 3)
    bNumbersMap.putAll(setOf("four" to 4, "five" to 5))
    println("bNumbersMap: $bNumbersMap")

    val cNumbersMap = mutableMapOf("one" to 1, "two" to 2)
    val previousValue = cNumbersMap.put("one", 11)
    println("value associated with 'one', before: $previousValue, " +
            "after: ${cNumbersMap["one"]}")
    println("cNumbersMap: $cNumbersMap")
    println()

    /**
     * You can also add new entries to maps using the shorthand operator form.
     * There are two ways:
     * [1] plusAssign (+=) operator.
     * [2] the [] operator alias for set().
     * NOTE: When called with the key present in the map, operators overwrite the
     * values of the corresponding entries.
     */
    val dNumbersMap = mutableMapOf("one" to 1, "two" to 2)
    dNumbersMap["three"] = 3     // calls numbersMap.put("three", 3)
    dNumbersMap += mapOf("four" to 4, "five" to 5)
    println("dNumbersMap: $dNumbersMap")
    println()

    /**
     * To remove an entry from a mutable map, use the remove() function. When calling
     * remove(), you can pass either a key or a whole key-value-pair. If you specify both
     * the key and value, the element with this key will be removed only if its value
     * matches the second argument
     */
    val eNumbersMap = mutableMapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    eNumbersMap.remove("one")
    println(eNumbersMap)
    eNumbersMap.remove("three", 4)            //doesn't remove anything
    eNumbersMap.remove("four", 4)
    println(eNumbersMap)
    println()

    /**
     * You can also remove entries from a mutable map by their keys or values. To do this,
     * call remove() on the map's keys or values providing the key or value of an entry.
     * When called on values, remove() removes only the first entry with the given value.
     */
    val fNumbersMap = mutableMapOf("one" to 1, "two" to 2, "three" to 3, "threeAgain" to 3)
    fNumbersMap.keys.remove("one")
    println("fNumbersMap: $fNumbersMap")
    fNumbersMap.values.remove(3)
    println("fNumbersMap: $fNumbersMap")
    println()

    // The minusAssign (-=) operator is also available for mutable maps.
    val gNumbersMap = mutableMapOf("one" to 1, "two" to 2, "three" to 3)
    gNumbersMap -= "two"
    println("gNumbersMap: $gNumbersMap")
    gNumbersMap -= "five"             //doesn't remove anything
    println("gNumbersMap: $gNumbersMap")
}