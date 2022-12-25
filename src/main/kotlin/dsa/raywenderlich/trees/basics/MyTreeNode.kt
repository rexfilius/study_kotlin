package raywenderlich.trees.basics

import raywenderlich.queue.basicQueue.QueueOnArrayList

typealias Visitor<T> = (MyTreeNode<T>) -> Unit

/**
 * - The tree is a data structure of profound importance. It's used to tackle many
 * recurring challenges in software development, such as:
 * (1) Representing hierarchical relationships. (2) Managing sorted data.
 * (3) Facilitating fast lookup operations.
 * There are many types of trees, and they come in various shapes and sizes
 *
 * - Trees are made up of NODES. A node encapsulates some data and keeps track
 * of its children.
 * - Every node, except for the first one, is connected to a single node above,
 * which is referred to as a PARENT NODE. The nodes directly below and connected
 * to the parent node are known as CHILD NODES. In a tree, every child has exactly
 * one parent
 *
 * - The topmost node in the tree is called the ROOT of the tree.
 * - A node that has no children is called a LEAF.
 */
class MyTreeNode<T>(val value: T) {

    /**
     * Each node in a tree is responsible for a value and holds references to
     * all of its children using a mutable list.*/
    val children: MutableList<MyTreeNode<T>> = mutableListOf()

    fun add(child: MyTreeNode<T>) = children.add(child)

    /**
     * - Depth-first traversal starts at the root node and explores the tree as far
     * as possible along each branch before reaching a leaf and then backtracking.
     * - This function uses recursion to process the next node. You could use your
     * own stack if you didn't want your implementation to be recursive. However,
     * the recursive solution is more simple and elegant to code.
     */
    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }

    /**
     * - Level-order traversal is a technique that visits each node of the tree
     * based on the depth of the nodes. Starting at the root, every node on a level
     * is visited before going to a lower level.
     * - You use a queue to ensure that nodes are visited in the right level-order.
     * You start visiting the current node and putting all its children into the
     * queue. Then you start consuming the queue until it's empty. Every time you
     * visit a node, you also put all it's children into the queue. This ensures
     * that all node at the same level are visited one after the other.
     */
    fun forEachLevelOrder(visit: Visitor<T>) {
        visit(this)
        val queue = QueueOnArrayList<MyTreeNode<T>>()
        children.forEach { queue.enqueue(it) }

        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }

    /**
     * - Since we have a method that iterates through the nodes, building a search
     * algorithm is not far-fetched.
     * - You use level-order traversal algorithm. Since it visits all nodes, if there
     * are multiple matches, the last match wins. This means that you'll get
     * different objects back depending on what traversal you use.
     */
    fun search(value: T): MyTreeNode<T>? {
        var result: MyTreeNode<T>? = null

        forEachLevelOrder {
            if (it.value == value) result = it
        }
        return result
    }
}
