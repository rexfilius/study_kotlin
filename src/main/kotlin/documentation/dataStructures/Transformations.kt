package documentation.dataStructures

/**
 * The Kotlin standard library provides a set of extension functions for collection
 * transformations. These functions build new collections from existing ones based on
 * the transformation rules provided
 */

fun main() {

    /**
     * MAP
     * The mapping transformation creates a collection from the results of a function on
     * the elements of another collection. The basic mapping function is map(). It applies
     * the given lambda function to each subsequent element and returns the list of the
     * lambda results. The order of results is the same as the original order of elements.
     * To apply a transformation that additionally uses the element index as an argument,
     * use mapIndexed()
     */
    val numbers = setOf(1, 2, 3)
    println(numbers.map { it * 3 })
    println(numbers.mapIndexed { idx, value -> value * idx })
    println()

    /**
     * If the transformation produces null on certain elements, you can filter out the
     * null from the result collection by calling the mapNotNull() function instead of
     * map(), or mapIndexedNotNull() instead of mapIndexed()
     */
    val num = setOf(1, 2, 3)
    println(num.mapNotNull { if (it == 2) null else it * 3 })
    println(num.mapIndexedNotNull { idx, value -> if (idx == 0) null else value * idx })
    println()

    /**
     * When transforming maps, you have two options: transform keys leaving values
     * unchanged and vice versa. To apply a given transformation to keys, use mapKeys();
     * in turn, mapValues() transforms values. Both functions use the transformations
     * that take a map entry as an argument, so you can operate both its key and value
     */
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    println(numbersMap.mapKeys { it.key.uppercase() })
    println(numbersMap.mapValues { it.value + it.key.length })
    println()

    /**
     * ZIP
     * Zipping transformation is building pairs from elements with the same positions in
     * both collections. In the Kotlin standard library, this is done by the zip()
     * extension function. When called on a collection or an array with another collection
     * (array) as an argument, zip() returns the List of Pair objects. The elements of the
     * receiver collection are the first elements in these pairs.
     * If the collections have different sizes, the result of the zip() is the smaller
     * size; the last elements of the larger collection are not included in the result.
     * zip() can also be called in the infix form a zip b
     */
    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    println(colors zip animals)

    val twoAnimals = listOf("fox", "bear")
    println(colors.zip(twoAnimals))
    println()

    /**
     * You can also call zip() with a transformation function that takes two parameters:
     * the receiver element and the argument element. In this case, the result List
     * contains the return values of the transformation function called on pairs of the
     * receiver and the argument elements with the same positions
     */
    val colour = listOf("red", "brown", "grey")
    val animal = listOf("fox", "bear", "wolf")
    println(colour.zip(animal) { col, anim ->
        "The ${anim.capitalize()} is $col"
    })
    println()

    /**
     * When you have a List of Pair's, you can do the reverse transformation – unzipping –
     * that builds two lists from these pairs:
     * The first list contains the first elements of each Pair in the original list.
     * The second list contains the second elements.
     * To unzip a list of pairs, call unzip()
     */
    val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    println(numberPairs.unzip())
}