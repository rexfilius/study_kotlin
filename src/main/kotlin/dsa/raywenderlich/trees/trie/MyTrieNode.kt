package raywenderlich.trees.trie

/**
 * - The trie (pronounced try) is a tree that specializes in storing data that can be
 * represented as a collection, such as English words
 * - Each character in a string is mapped to a node. The last node in each string is
 * marked as a terminating node. The benefits of a trie are best illustrated by
 * looking at it in the context of prefix matching.
 * - key holds the data for the node. This is optional because the root node of the
 * trie has no key.
 * - A TrieNode holds a reference to its parent. This reference simplifies
 * remove() operation later on.
 * - In binary search trees, nodes have a left and right child. In a trie, a node
 * needs to hold multiple different elements. You've declared a children map to
 * help with that.
 * -isTerminating acts as an indicator for the end of a collection.
 */
class MyTrieNode<Key>(
    var key: Key?,
    var parent: MyTrieNode<Key>?
) {

    val children: HashMap<Key, MyTrieNode<Key>> = HashMap()

    var isTerminating = false

}