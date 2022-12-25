package raywenderlich.queue.basicQueue

import raywenderlich.linkedList.MyDoublyLinkedList

/**
 * - Space complexity for LinkedListQueue is O(n)
 * - The main weakness with LinkedListQueue, despite O(1) performance, is it suffers
 * from high overhead. Each element has to have extra storage for the forward and
 * back reference. Moreover, every time you create a new element, it requires a
 * relatively expensive dynamic allocation. By contrast, ArrayListQueue does bulk
 * allocation, which is faster
 * */
class QueueOnLinkedList<T> : MyQueueInterface<T> {

    private val list = MyDoublyLinkedList<T>()
    private var size = 0

    override val count: Int
        get() = size

    /**
     * - Best and Worse case: O(1) time complexity
     */
    override fun enqueue(element: T): Boolean {
        list.append(element)
        size++
        return true
    }

    /**
     * - Best and Worse case: O(1) time complexity
     */
    override fun dequeue(): T? {
        val firstNode = list.first ?: return null
        size--
        return list.remove(firstNode)
    }

    override fun peek(): T? {
        return list.first?.value
    }

    override fun toString(): String {
        return list.toString()
    }

}