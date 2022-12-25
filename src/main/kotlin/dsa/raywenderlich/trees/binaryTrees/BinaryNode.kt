package raywenderlich.trees.binaryTrees

typealias Visitor<T> = (T) -> Unit

/**
 * - A binary tree is a tree in which each node has at most two children,
 * often referred to as the left and right children
 * - Key operations: [traverseInOrder], [traversePreOrder], [traversePostOrder]
 * - Each one of these traversal algorithms has both a time and space complexity of O(n).
 */
class BinaryNode<T>(var value: T) {

    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    /**
     * - This recursive min property in BinaryNode will help you find the minimum
     * node in a subtree.
     */
    val min: BinaryNode<T>
        get() = leftChild?.min ?: this

    /**
     * - You first traverse to the left-most node before visiting the value.
     * You then traverse to the right-most node.
     */
    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    /**
     * - In pre-order traversal you visit the current node first,
     * then recursively visits the left and right child.
     */
    fun traversePreOrder(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    /**
     * - In post-order traversal, you recursively visit the left and right child,
     * then only visits the current node after the left and right child have been
     * visited recursively.
     * - In other words, given any node, you'll visit its children before visiting
     * itself. An interesting consequence of this is that the root node is always
     * visited last.
     */
    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }

    override fun toString() = diagram(this)

    private fun diagram(
        node: BinaryNode<T>?,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(node.leftChild, "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }

    fun traversePreOrderWithNull(visit: (T?) -> Unit) {
        visit(value)
        leftChild?.traversePreOrderWithNull(visit) ?: visit(null)
        rightChild?.traversePreOrderWithNull(visit) ?: visit(null)
    }

}