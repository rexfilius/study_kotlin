package raywenderlich.trees.binaryTrees

/**
 * - A binary search tree, or BST, is a data structure that facilitates fast lookup,
 * insert and removal operations
 * - A binary search tree imposes two rules on the binary tree.
 * (1) The value of a left child must be less than the value of its parent.
 * (2) Consequently, the value of a right child must be greater than or equal
 * to the value of its parent.
 * - Binary search trees use this property to save you from performing unnecessary
 * checking. As a result, lookup, insert and removal have an average time complexity
 * of O(log n), which is considerably faster than linear data structures such as
 * arrays and linked lists.
 * - By definition, binary search trees can only hold values that are Comparable.
 * - Key operations: [insert], [remove],  [contains]
 */
class BST<T : Comparable<T>> {

    var root: BinaryNode<T>? = null

    override fun toString(): String = root?.toString() ?: "empty tree"

    fun insert(value: T) {
        root = insertNode(root, value)
    }

    private fun insertNode(node: BinaryNode<T>?, value: T): BinaryNode<T> {
        // A base case is required for terminating recursion. If the current node is
        // null, you've found the insertion point and return the new BinaryNode.
        node ?: return BinaryNode(value)

        if (value < node.value) {
            node.leftChild = insertNode(node.leftChild, value)
        } else {
            node.rightChild = insertNode(node.rightChild, value)
        }

        return node
    }

    /**
     * - This implementation of contains is an O(log n) operation in a
     * balanced binary search tree.
     */
    fun contains(value: T): Boolean {
        // set current to the root node.
        var current = root

        // While current is not null, check the current node's value.
        while (current != null) {
            // If the value is equal to what you're trying to find, return true.
            if (current.value == value) return true

            // Otherwise, decide whether you're going to check the left or right child.
            current = if (value < current.value) {
                current.leftChild
            } else {
                current.rightChild
            }
        }
        return false
    }

    fun remove(value: T) {
        root = removeNode(root, value)
    }

    private fun removeNode(node: BinaryNode<T>?, value: T): BinaryNode<T>? {
        node ?: return null

        when {
            value == node.value -> {
                // If node is a leaf node, you simply return null,
                // thereby removing the current node.
                if (node.leftChild == null && node.rightChild == null) return null
                // If the node has no left child, you return node.rightChild
                // to reconnect the right subtree.
                if (node.leftChild == null) return node.rightChild
                // If the node has no right child, you return node.leftChild
                // to reconnect the left subtree.
                if (node.rightChild == null) return node.leftChild
                // If the node to be removed has both a left and right child.
                // You replace the node's value with the smallest value from the
                // right subtree. You then call remove on the right child
                // to remove this swapped value.
                node.rightChild?.min?.value?.let {
                    node.value = it
                }
                node.rightChild = removeNode(node.rightChild, node.value)
            }
            value < node.value ->
                node.leftChild = removeNode(node.leftChild, value)
            else ->
                node.rightChild = removeNode(node.rightChild, value)
        }
        return node
    }

    /**
     * - A method that checks if the current tree contains all the elements of
     * another tree. In other words, the values in the current tree must be a
     * superset of the values in the other tree.
     * - O(n) space and time complexity
     */
    fun containsElements(subTree: BST<T>): Boolean {
        // Insert all the elements of the current tree into a set.
        val set = mutableSetOf<T>()
        root?.traverseInOrder { set.add(it) }

        // isEqual will store the result. For every element in the subtree, you check
        // if the value is contained in the set. If at any point set.contains(it)
        // evaluates to false, you'll make sure isEqual stays false even if
        // subsequent elements evaluate to true by assigning
        // isEqual && list.contains(it) to itself.
        var isEqual = true
        subTree.root?.traverseInOrder {
            isEqual = isEqual && set.contains(it)
        }
        return isEqual
    }
}