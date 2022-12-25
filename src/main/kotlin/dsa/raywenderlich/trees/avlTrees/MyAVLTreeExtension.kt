package raywenderlich.trees.avlTrees

import kotlin.math.pow

/**
 * - How many leaf nodes are there in a perfectly balanced tree of height 3? What
 * about a perfectly balanced tree of height h?
 * - A perfectly balanced tree is a tree where all the leaves are at the same level,
 * and that level is completely filled
 * - Since each node has two children, the number of leaf nodes doubles as the height
 * increases. Therefore, you can calculate the number of leaf nodes using a simple equation
 */
fun leafNodes(height: Int): Int {
    return 2.0.pow(height).toInt()
}

/**
 * - How many nodes are there in a perfectly balanced tree of height 3? What about
 * a perfectly balanced tree of height h?
 */
fun nodes(height: Int): Int {
    return 2.0.pow(height + 1).toInt() - 1
}