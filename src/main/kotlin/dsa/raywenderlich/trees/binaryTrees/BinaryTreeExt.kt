package raywenderlich.trees.binaryTrees

import kotlin.math.max

/**
 * - Given a binary tree, find the height of the tree. The height of the binary
 * tree is determined by the distance between the root and the furthest leaf.
 * The height of a binary tree with a single node is zero since the single node
 * is both the root and the furthest leaf.
 * - You recursively call the height function. For every node you visit, you add
 * one to the height of the highest child. If the node is null, you return -1.
 * - This algorithm has a time complexity of O(n) since you need to traverse
 * through all the nodes. This algorithm incurs a space cost of O(n) since you
 * need to make the same n recursive calls to the call stack.
 */
fun <T> BinaryNode<T>?.heightExt(): Int {
    return if (this != null) {
        1 + max(this.leftChild.heightExt(), this.rightChild.heightExt())
    } else -1
}

/**
 * - A common task in software development is serializing an object into another data
 * type. This process is known as serialization, and it allows custom types to be used
 * in systems that only support a closed set of data types.
 * - An raywenderlich.util.example of serialization is JSON. Your task is to devise a way to serialize
 * a binary tree into a list, and a way to deserialize the list back into the same binary tree.
 */
fun <T> BinaryNode<T>.serializeExt(): MutableList<T?> {
    val list = mutableListOf<T?>()
    this.traversePreOrderWithNull { list.add(it) }
    return list
}

fun <T> MutableList<T?>.deserializeExt(): BinaryNode<T?>? {
    val rootValue = this.removeAt(this.size - 1) ?: return null

    val root = BinaryNode<T?>(rootValue)
    root.leftChild = this.deserializeExt()
    root.rightChild = this.deserializeExt()

    return root
}

fun <T> MutableList<T?>.deserializeOptimizedExt(): BinaryNode<T?>? {
    return this.asReversed().deserializeExt()
}

fun <T : Comparable<T>> BST<T>.containsElementsExt(): Boolean {
    val set = mutableSetOf<T>()
    this.root?.traverseInOrder {
        set.add(it)
    }

    var isEqual = true
    this.root?.traverseInOrder {
        isEqual = isEqual && set.contains(it)
    }
    return isEqual
}