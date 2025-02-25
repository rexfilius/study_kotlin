package documentation.dataStructures

/**
 * Collection<T> is the root of the collection hierarchy. This interface represents the
 * common behavior of a read-only collection: retrieving size, checking item membership,
 * and so on. Collection inherits from the Iterable<T> interface that defines the
 * operations for iterating elements. You can use Collection as a parameter of a function
 * that applies to different collection types. For more specific cases,
 * use the Collection's inheritors: List and Set.
 */
fun printAll(strings: Collection<String>) {
    for (s in strings) print("$s..")
    println()
}

// MutableCollection<T> is a Collection with write operations, such as add and remove.
fun List<String>.getShortWordsTo(shortWords: MutableList<String>, maxLength: Int) {
    this.filterTo(shortWords) { it.length <= maxLength }
    val articles = setOf("a", "A", "an", "An", "the", "The")
    shortWords -= articles
}

fun main() {

    val stringList = listOf("one", "two", "one")
    printAll(stringList)

    val stringSet = setOf("one", "two", "three")
    printAll(stringSet)

    val words = "A long time ago in a galaxy far far away".split(" ")
    val shortWords = mutableListOf<String>()
    words.getShortWordsTo(shortWords, 3)
    println("short words: $shortWords")
}