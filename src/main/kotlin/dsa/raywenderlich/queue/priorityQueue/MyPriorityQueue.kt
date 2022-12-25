package raywenderlich.queue.priorityQueue

import raywenderlich.heap.MyHeapInterface
import raywenderlich.queue.basicQueue.MyQueueInterface

/**
 * - Queues are lists that maintain the order of elements using FIFO ordering.
 * A priority queue is another version of a queue. However, instead of using FIFO
 * ordering, elements are dequeued in priority order.
 * - A priority queue can have either a:
 * (1) Max-priority: The element at the front is always the largest.
 * (2) Min-priority: The element at the front is always the smallest.
 * - A priority queue is especially useful when you need to identify the maximum or
 * minimum value within a list of elements.
 * - Some applications of a priority queue include:
 * (1) Dijkstra’s algorithm: Uses a priority queue to calculate the minimum cost.
 * (2) A* pathfinding algorithm: Uses a priority queue to track the unexplored routes
 * that will produce the path with the shortest length.
 * (3) Heap sort: Many heap sorts use a priority queue.
 * (4) Huffman coding: Useful for building a compression tree. A min-priority queue is
 * used to repeatedly find two nodes with the smallest frequency that don't yet have
 * a parent node.
 */
abstract class MyPriorityQueue<T> : MyQueueInterface<T> {

    abstract val heap: MyHeapInterface<T>

    override val count: Int
        get() = heap.count

    /**
     * O(log n) time
     */
    override fun enqueue(element: T): Boolean {
        heap.insert(element)
        return true
    }

    /**
     * O(log n) time
     */
    override fun dequeue(): T? {
        return heap.remove()
    }

    override fun peek(): T? {
        return heap.peek()
    }
}