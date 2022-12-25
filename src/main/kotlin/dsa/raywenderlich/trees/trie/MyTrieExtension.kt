package raywenderlich.trees.trie

fun MyTrie<Char>.insertChar(string: String) {
    insert(string.toList())
}

fun MyTrie<Char>.containsChar(string: String): Boolean {
    return contains(string.toList())
}

fun MyTrie<Char>.removeChar(string: String) {
    remove(string.toList())
}

/**
 * This extension maps the input string into a list of characters, and then maps the
 * lists in the result of the collections() call back to strings.
 */
fun MyTrie<Char>.collectionsChar(prefix: String): List<String> {
    return collections(prefix.toList()).map {
        it.joinToString(separator = "")
    }
}
