package raywenderlich.queue.basicQueue

/**
 * Space complexity for enqueue and dequeue operation is O(n)
 */
class QueueOnArrayList<T> : MyQueueInterface<T> {

    private val list = arrayListOf<T>()

    /** O(1) time complexity: getting the list size*/
    override val count: Int
        get() = list.size

    /**
     * O(1) time complexity
     */
    override fun peek(): T? {
        return list.getOrNull(0)
    }

    /**
     * - Best and Worst case: O(1) time complexity.
     */
    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }

    /**
     * - If the queue is empty, return null, otherwise, remove the element from the
     * front of the list and return it.
     * - Best and Worst Case: O(n) time complexity, because, after removing the
     * element at the front, all the remaining elements have to be shifted in memory.
     */
    override fun dequeue(): T? {
        return if (isEmpty) null
        else list.removeAt(0)
    }

    override fun toString(): String = list.toString()
}