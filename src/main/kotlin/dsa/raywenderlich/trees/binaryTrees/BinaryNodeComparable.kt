package raywenderlich.trees.binaryTrees

import kotlin.math.max

class BinaryNodeComparable<T : Comparable<T>>(var value: T) {

    var leftChild: BinaryNodeComparable<T>? = null
    var rightChild: BinaryNodeComparable<T>? = null

    /**
     * - This recursive min property in BinaryNode will help you find the minimum
     * node in a subtree.
     */
    val min: BinaryNodeComparable<T>
        get() = leftChild?.min ?: this

    val isBinarySearchTree: Boolean
        get() = isBST(tree = this, min = null, max = null)

    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    fun traversePreOrder(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePreOrder(visit)
        visit(value)
    }

    override fun toString() = diagram(this)

    private fun diagram(
        node: BinaryNodeComparable<T>?,
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

    fun height(node: BinaryNodeComparable<T>? = this): Int {
        return node?.let {
            1 + max(height(node.leftChild), height(node.rightChild))
        } ?: -1
    }

    fun traversePreOrderWithNull(visit: (T?) -> Unit) {
        visit(value)
        leftChild?.traversePreOrderWithNull(visit) ?: visit(null)
        rightChild?.traversePreOrderWithNull(visit) ?: visit(null)
    }

    fun serialize(node: BinaryNodeComparable<T> = this): MutableList<T?> {
        val list = mutableListOf<T?>()
        node.traversePreOrderWithNull { list.add(it) }
        return list
    }

    /*private fun deserialize(list: MutableList<T?>): BinaryNodeComparable<T?>? {
        val rootValue = list.removeAt(list.size - 1) ?: return null

        val root = MyBinaryNodeComparable<T?>(rootValue)

        root.leftChild = deserialize(list)
        root.rightChild = deserialize(list)

        return root
    }
    fun deserializeOptimized(list: MutableList<T?>): MyBinaryNodeComparable<T?>? {
        return deserialize(list.asReversed())
    }*/

    /**
     * - A function that checks if a binary tree is a binary search tree.
     * - A binary search tree is a tree where every left child is less than or equal
     * to its parent, and every right child is greater than its parent. An algorithm
     * that verifies whether a tree is a binary search tree involves going through
     * all the nodes and checking for this property.
     * - [isBST] is responsible for recursively traversing through the tree and
     * checking for the BST property. It needs to keep track of progress via a
     * reference to a BinaryNode and also keep track of the min and max values
     * to verify the BST property.
     */
    private fun isBST(tree: BinaryNodeComparable<T>?, min: T?, max: T?): Boolean {
        // Base case: if tree is null, there are no nodes to inspect. A null node
        // is a BST, so you return true in this case
        tree ?: return true

        // A bounds check: if the current value exceeds the bounds of the min and max
        // values, the current node does not respect the binary search tree rules.
        if (min != null && tree.value <= min) {
            return false
        } else if (max != null && tree.value > max) {
            return false
        }

        // This line contains the recursive calls. When traversing through the left
        // children, the current value is passed in as the max value. This is because
        // nodes on the left side cannot be greater than the parent. Vice versa, when
        // traversing to the right, the min value is updated to the current value.
        // Nodes on the right side must be greater than the parent. If any of the
        // recursive calls evaluate false, the false value will propagate to the top.
        return isBST(tree.leftChild, min, tree.value) &&
                isBST(tree.rightChild, tree.value, max)
    }

    /**
     * - Override equals() to check whether two binary search trees are equal.
     * - For two binary trees to be equal, both trees must have the same elements
     * in the same order
     * - [equals] recursively checks two nodes and their descendants for equality
     * - O(n) space and time complexity
     */
    override fun equals(other: Any?): Boolean {
        // You check the value of the left and right nodes for equality. You also
        // recursively check the left children and the right children for equality.
        return if (other != null && other is BinaryNodeComparable<*>) {
            this.value == other.value && this.leftChild == other.leftChild
                    && this.rightChild == other.rightChild
        } else {
            false
        }
    }

    // Placeholder
    override fun hashCode(): Int {
        var result = value.hashCode()
        result = 31 * result + (leftChild?.hashCode() ?: 0)
        result = 31 * result + (rightChild?.hashCode() ?: 0)
        return result
    }
}