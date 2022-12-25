package dataStructures

fun main() {

    /**
     * For retrieving a value from a map, you must provide its key as an argument of the
     * get() function. The shorthand "[key]" syntax is also supported. If the given key is
     * not found, it returns null. There is also the function getValue() which has
     * slightly different behavior: it throws an exception if the key is not found
     * in the map. Additionally, you have two more options to handle the key absence:
     * ...
     * getOrElse() works the same way as for lists: the values for non-existent keys are
     * returned from the given lambda function.
     * getOrDefault() returns the specified default value if the key is not found.
     */
    val aNumbersMap = mapOf("one" to 1, "two" to 2, "three" to 3)
    println(aNumbersMap.get("one"))
    println(aNumbersMap["one"])
    println(aNumbersMap.getOrDefault("four", 10))
    println(aNumbersMap["five"])    // null
    //aNumbersMap.getValue("six")   // exception!
    println()

    /**
     * To perform operations on all keys or all values of a map, you can retrieve them
     * from the properties keys and values accordingly. keys is a set of all map keys
     * and values is a collection of all map values
     */
    val bNumbersMap = mapOf("one" to 1, "two" to 2, "three" to 3)
    println(bNumbersMap.keys)
    println(bNumbersMap.values)
    //println(bNumbersMap.entries)
    println()

    /**
     * You can filter maps with the filter() function as well as other collections. When
     * calling filter() on a map, pass to it a predicate with a Pair as an argument. This
     * enables you to use both the key and the value in the filtering predicate.
     */
    val cNumbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filteredMap = cNumbersMap.filter { (key, value) ->
        key.endsWith("1") && value > 10
    }
    println(filteredMap)

    /**
     * There are also two specific ways for filtering maps: by keys and by values. For
     * each way, there is a function: filterKeys() and filterValues(). Both return a new
     * map of entries which match the given predicate. The predicate for filterKeys()
     * checks only the element keys, the one for filterValues() checks only values.
     */
    val dNumbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filteredKeysMap = dNumbersMap.filterKeys { it.endsWith("1") }
    val filteredValuesMap = dNumbersMap.filterValues { it < 10 }

    println("filteredKeysMap: $filteredKeysMap")
    println("filteredValuesMap: $filteredValuesMap")
    println()

    /**
     * Due to the key access to elements, plus (+) and minus (-) operators work for maps
     * differently than for other collections. plus returns a Map that contains elements
     * of its both operands: a Map on the left and a Pair or another Map on the right.
     * When the right-hand side operand contains entries with keys present in the
     * left-hand side Map, the result map contains the entries from the right side
     */
    val eNumbersMap = mapOf("one" to 1, "two" to 2, "three" to 3)
    println(eNumbersMap + Pair("four", 4))
    println(eNumbersMap + Pair("one", 10))
    println(eNumbersMap + mapOf("five" to 5, "one" to 11))
    println()

    /**
     * minus creates a Map from entries of a Map on the left except those with keys from
     * the right-hand side operand. So, the right-hand side operand can be either a single
     * key or a collection of keys: list, set, and so on.
     */
    val fNumbersMap = mapOf("one" to 1, "two" to 2, "three" to 3)
    println(fNumbersMap - "one")
    println(fNumbersMap - listOf("two", "four"))
    println()

}