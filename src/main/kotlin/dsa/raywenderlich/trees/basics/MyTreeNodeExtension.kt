package raywenderlich.trees.basics

import raywenderlich.queue.basicQueue.QueueOnArrayList

/**
 * - Print the values in a tree in an order based on their level. Nodes belonging
 * to the same level should be printed on the same line.
 * - A straightforward way to print the nodes in level-order is to leverage the
 * level-order traversal using a Queue data structure. The tricky bit is
 * determining when a newline should occur.
 * - O(n) time complexity. Since you initialize the Queue data structure as an
 * intermediary container, this algorithm also uses O(n) space
 */
fun <T> MyTreeNode<T>.printEachLevel() {

    // initialize a Queue to facilitate the level-order traversal.
    val queue = QueueOnArrayList<MyTreeNode<T>>()

    // create variable to keep track of the number of nodes you'll need
    // to work on before you print a new line.
    var nodesLeftInCurrentLevel: Int

    queue.enqueue(this)

    // Your level-order traversal continues until your queue is empty.
    while (queue.isEmpty.not()) {
        // Inside the first while loop, you begin by setting
        // nodesLeftInCurrentLevel to the current elements in the queue.
        nodesLeftInCurrentLevel = queue.count

        // Using another while loop, you dequeue the first nodesLeftInCurrentLevel
        // number of elements from the queue. Every element you dequeue is printed
        // without establishing a new line. You also enqueue all the children
        // of the node.
        while (nodesLeftInCurrentLevel > 0) {
            val node = queue.dequeue()
            node?.let {
                print("${node.value} ")
                node.children.forEach { queue.enqueue(it) }
                nodesLeftInCurrentLevel--
            } ?: break
        }

        // You generate the new line using println(). In the next iteration,
        // nodesLeftInCurrentLevel is updated with the count of the queue,
        // representing the number of children from the previous iteration.
        println()
    }

}