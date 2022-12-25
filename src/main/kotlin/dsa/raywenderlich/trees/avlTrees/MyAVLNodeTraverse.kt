package raywenderlich.trees.avlTrees

typealias TraverseVisitor<T> = (T) -> Unit

class MyAVLNodeTraverse<T : Comparable<T>>(value: T)
    : TraversableBinaryNode<MyAVLNodeTraverse<T>, T>(value) {

    val min: MyAVLNodeTraverse<T>
        get() = leftChild?.min ?: this

    var height = 0

    val leftHeight: Int
        get() = leftChild?.height ?: -1

    val rightHeight: Int
        get() = rightChild?.height ?: -1

    val balanceFactor: Int
        get() = leftHeight - rightHeight

    override fun toString() = diagram(this)

    private fun diagram(
        node: MyAVLNodeTraverse<T>?,
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

}

abstract class TraversableBinaryNode<Self : TraversableBinaryNode<Self, T>, T>(
    var value: T
) {
    var leftChild: Self? = null
    var rightChild: Self? = null

    fun traverseInOrder(visit: TraverseVisitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    fun traversePreOrder(visit: TraverseVisitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    fun traversePostOrder(visit: TraverseVisitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }
}