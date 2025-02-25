package documentation.dataStructures

fun main() {

    /**
     * ASSOCIATE
     * Association transformations allow building maps from the collection elements and
     * certain values associated with them. In different association types, the elements
     * can be either keys or values in the association map.
     * The basic association function associateWith() creates a Map in which the elements
     * of the original collection are keys, and values are produced from them by the given
     * transformation function. If two elements are equal,
     * only the last one remains in the map
     */
    val numbers = listOf("one", "two", "three", "four")
    println(numbers.associateWith { it.length })
    println()

    /**
     * For building maps with collection elements as values, there is a function
     * associateBy(). It takes a function that returns a key based on an element's value.
     * If two elements are equal, only the last one remains in the map. associateBy() can
     * be called with a value transformation function
     */
    val num = listOf("one", "two", "three", "four")
    println(num.associateBy { it.first().uppercase() })

    println(num.associateBy(
            keySelector = { it.first().uppercase() },
            valueTransform = { it.length }))
    println()

    /**
     * Another way to build maps in which both keys and values are somehow produced from
     * collection elements is the function associate(). It takes a lambda function that
     * returns a Pair: the key and the value of the corresponding map entry.
     * Note that associate() produces short-living Pair objects which may affect the
     * performance. Thus, associate() should be used when the performance isn't critical
     * or it's more preferable than other options. An example of the latter is when a key
     * and the corresponding value are produced from an element together
     */
    /*val names = listOf("Alice Adams", "Brian Brown", "Clara Campbell")
    println(names.associate { name ->
        parseFullName(name).let {
            it.lastName to it.firstName
        }
    })*/
}

fun parseFullName(name: String): String {
    return "${name[0]} ${name[1]}"
}