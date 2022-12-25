package raywenderlich.trees.avlTrees

typealias AVLvisitor<T> = (T) -> Unit

class AVLNode<T>(var value: T) {

    var leftChild: AVLNode<T>? = null
    var rightChild: AVLNode<T>? = null

    val min: AVLNode<T>
        get() = leftChild?.min ?: this

    /**
     * - To keep a binary tree balanced, you need a way to measure the balance of the
     * tree. The AVL tree achieves this with a height property in each node. In
     * tree-speak, the height of a node is the longest distance from the current
     * node to a leaf node.
     * - You'll use the relative heights of a node's children to determine whether
     * a particular node is balanced.
     * - The height of the left and right children of each node must differ at most
     * by 1. This is known as the BALANCE FACTOR.
     */
    var height = 0

    val leftHeight: Int
        get() = leftChild?.height ?: -1

    val rightHeight: Int
        get() = rightChild?.height ?: -1

    /**
     * - The balanceFactor computes the height difference of the left and right child.
     * If a particular child is null, its height is considered to be -1.
     */
    val balanceFactor: Int
        get() = leftHeight - rightHeight

    override fun toString() = diagram(this)

    private fun diagram(
        node: AVLNode<T>?,
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

    fun traverseInOrder(visit: AVLvisitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    fun traversePreOrder(visit: AVLvisitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    fun traversePostOrder(visit: AVLvisitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }

}