package raywenderlich.trees.avlTrees

import kotlin.math.max

/**
 * - A balanced tree is the key to optimizing the performance of the binary search
 * tree. There are three main states of balance.
 * - Perfectly Balanced State: Ideal form. In technical terms, this means every
 * level of the tree is filled with nodes from top to bottom.
 * - Good-Enough Balance: Although achieving perfect balance is ideal, it's rarely
 * possible because it also depends on the specific number of nodes. Because of this,
 * a different definition exists. A balanced tree must have all its levels
 * filled, except for the bottom one. In most cases of binary trees, this is the
 * best you can do.
 * Unbalanced: Binary search trees in this state suffer from various levels of
 * performance loss depending on the degree of imbalance.
 * - Keeping the tree balanced gives the find, insert and remove operations an
 * O(log n) time complexity. AVL trees maintain balance by adjusting the structure
 * of the tree when the tree becomes unbalanced
 */
class AVLTree<T : Comparable<T>> {

    private var root: AVLNode<T>? = null

    fun insert(value: T) {
        root = insertNode(root, value)
    }

    /**
     * - Instead of returning the node directly after inserting, you pass it into
     * [balanced]. This ensures every node in the call stack is checked for
     * balancing issues. You also update the node's height.
     */
    private fun insertNode(node: AVLNode<T>?, value: T): AVLNode<T> {
        node ?: return AVLNode(value)

        if (value < node.value) {
            node.leftChild = insertNode(node.leftChild, value)
        } else {
            node.rightChild = insertNode(node.rightChild, value)
        }

        val balancedNode = balanced(node)
        balancedNode.height =
            max(balancedNode.leftHeight, balancedNode.rightHeight) + 1

        return balancedNode
    }

    fun remove(value: T) {
        root = removeNode(root, value)
    }

    private fun removeNode(node: AVLNode<T>?, value: T): AVLNode<T>? {
        node ?: return null

        when {
            value == node.value -> {
                if (node.leftChild == null && node.rightChild == null) return null

                if (node.leftChild == null) return node.rightChild

                if (node.rightChild == null) return node.leftChild

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

        val balancedNode = balanced(node)
        balancedNode.height =
            max(balancedNode.leftHeight, balancedNode.rightHeight) + 1
        return balancedNode
    }

    override fun toString() = root?.toString() ?: "empty tree"

    fun contains(value: T): Boolean {
        var current = root

        while (current != null) {
            if (current.value == value) return true

            current = if (value < current.value) {
                current.leftChild
            } else {
                current.rightChild
            }
        }

        return false
    }

    private fun leftRotate(node: AVLNode<T>): AVLNode<T> {
        // The right child is chosen as the pivot. This node replaces the rotated
        // node as the root of the subtree (it moves up a level).
        val pivot = node.rightChild!!
        // The node to be rotated becomes the left child of the pivot (it moves down
        // a level). This means that the current left child of the pivot must
        // be moved elsewhere.
        node.rightChild = pivot.leftChild
        // The pivot's leftChild can now be set to the rotated node.
        pivot.leftChild = node

        // You update the heights of the rotated node and the pivot.
        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1

        // Return the pivot so that it can replace the rotated node in the tree.
        return pivot
    }

    /**
     * - This is nearly identical to the implementation of [leftRotate], except the
     * references to the left and right children have been swapped.
     */
    private fun rightRotate(node: AVLNode<T>): AVLNode<T> {
        // The left child is chosen as the pivot. This node replaces the rotated
        // node as the root of the subtree (it moves up a level).
        val pivot = node.leftChild!!
        // The node to be rotated becomes the right child of the pivot (it moves down
        // a level). This means that the current right child of the pivot must
        // be moved elsewhere.
        node.leftChild = pivot.rightChild
        // The pivot's rightChild can now be set to the rotated node.
        pivot.rightChild = node

        // You update the heights of the rotated node and the pivot.
        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
        return pivot
    }

    private fun rightLeftRotate(node: AVLNode<T>): AVLNode<T> {
        val rightChild = node.rightChild ?: return node
        node.rightChild = rightRotate(rightChild)
        return leftRotate(node)
    }

    private fun leftRightNotate(node: AVLNode<T>): AVLNode<T> {
        val leftChild = node.leftChild ?: return node
        node.leftChild = leftRotate(leftChild) //rightRotate(leftChild)??
        return rightRotate(node)
    }

    /**
     * - Three cases to consider:
     * - A balanceFactor of 2 suggests that the left child is heavier (that is,
     * contains more nodes) than the right child. This means that you want to use
     * either right or left-right rotations.
     * - A balanceFactor of -2 suggests that the right child is heavier than the left
     * child. This means that you want to use either left or right-left rotations.
     * - The default case suggests that the particular node is balanced. There's
     * nothing to do here except to return the node.
     */
    private fun balanced(node: AVLNode<T>): AVLNode<T> {
        return when (node.balanceFactor) {
            2 -> {
                if (node.leftChild?.balanceFactor == -1)
                    leftRightNotate(node)
                else rightRotate(node)
            }
            -2 -> {
                if (node.rightChild?.balanceFactor == 1)
                    rightLeftRotate(node)
                else leftRotate(node)
            }
            else -> node
        }
    }

}