package raywenderlich.trees.trie

class MyTrie<Key> {

    private val root = MyTrieNode<Key>(key = null, parent = null)

    private val storedLists: MutableSet<List<Key>> = mutableSetOf()

    val lists: List<List<Key>>
        get() = storedLists.toList()

    val count: Int
        get() = storedLists.count()

    val isEmpty: Boolean
        get() = storedLists.isEmpty()

    /**
     * - Tries work with lists of the Key type. The trie takes the list and represents
     * it as a series of nodes in which each node maps to an element in the list.
     * - The time complexity for this algorithm is O(k), where k is the number of
     * elements in the list you're trying to insert. This is because you need to
     * traverse through or create each node that represents each element of the new list.
     */
    fun insert(list: List<Key>) {
        // current keeps track of your traversal progress,
        // which starts with the root node.
        var current = root

        // A trie stores each element of a list in separate nodes. For each element
        // of the list, you first check if the node currently exists in the children
        // map. If it doesn't, you create a new node. During each loop,
        // you move current to the next node.
        list.forEach { element: Key ->
            if (current.children[element] == null) {
                current.children[element] =
                    MyTrieNode(key = element, parent = current)
            }
            current = current.children[element]!!
        }

        // After iterating through the for loop, current should be referencing the
        // node representing the end of the list. You mark that node as the
        // terminating node.
        current.isTerminating = true
        storedLists.add(list)
    }

    /**
     * - Here, you traverse the trie in a way similar to insert. You check every
     * element of the list to see if it's in the tree. When you reach the last element
     * of the list, it must be a terminating element. If not, the list wasn't added
     * to the tree and what you've found is merely a subset of a larger list.
     * - The time complexity of contains is O(k), where k is the number of elements
     * in the list that you're looking for. This is because you need to traverse
     * through k nodes to find out whether the list is in the trie.
     */
    fun contains(list: List<Key>): Boolean {
        var current = root
        list.forEach { element: Key ->
            val child = current.children[element] ?: return false
            current = child
        }
        return current.isTerminating
    }

    /**
     * - The time complexity of this algorithm is O(k), where k represents the number
     * of elements of the collection that you're trying to remove.
     */
    fun remove(list: List<Key>) {
        // Check if the collection is part of the trie and to point current
        // to the last node of the collection.
        var current = root
        list.forEach { element ->
            val child = current.children[element] ?: return
            current = child
        }

        if (!current.isTerminating) return

        // set isTerminating to false so that the current node can be removed
        // by the loop in the next step.
        storedLists.remove(list)
        current.isTerminating = false

        // Since nodes can be shared, you don't want to carelessly remove elements
        // that belong to another collection. If there are no other children in the
        // current node, it means that other collections do not depend on the current
        // node.
        val parent = current.parent
        /*while (current.children.isEmpty() && !current.isTerminating) {
            parent?.let {
                it.children[current.key] = null    // ERROR
                current = it
            }
        }*/
    }

    /**
     * prefix matching algorithm
     */
    fun collections(prefix: List<Key>): List<List<Key>> {
        // start by verifying that the trie contains the prefix.
        // If not, you return an empty list.
        var current = root
        prefix.forEach { element: Key ->
            val child = current.children[element] ?: return emptyList()
            current = child
        }

        // After you've found the node that marks the end of the prefix, you call a
        // recursive helper method to find all the sequences after the current node.
        return collections(prefix = prefix, node = current)
    }

    private fun collections(
        prefix: List<Key>,
        node: MyTrieNode<Key>?
    ): List<List<Key>> {
        // Create a MutableList to hold the results. If the current node is a
        // terminating node, you add the corresponding prefix to the results.
        val results = mutableListOf<List<Key>>()
        if (node?.isTerminating == true) results.add(prefix)

        // Check the current node's children. For every child node, you
        // recursively call collections() to seek out other terminating nodes.
        node?.children?.forEach { (key, node) ->
            results.addAll(collections(prefix + key, node))
        }
        return results
    }
}