package raywenderlich.queue.priorityQueue

import raywenderlich.queue.basicQueue.MyQueueInterface

abstract class MyArrayListPriorityQueue<T> : MyQueueInterface<T> {

    protected val elements = ArrayList<T>()

    abstract fun sort()

    override val count: Int
        get() = elements.size

    /**
     * - Here, you're assuming that the ArrayList<T> is always sorted, and if it's not
     * empty, it always contains the element with the highest priority in position 0.
     */
    override fun peek(): T? {
        return elements.firstOrNull()
    }

    /**
     * O(n) time
     */
    override fun dequeue(): T? {
        return if(isEmpty) null
        else elements.removeAt(0)
    }

    override fun enqueue(element: T): Boolean {
        elements.add(element)
        sort()
        return true
    }

    override fun toString(): String = elements.toString()
}