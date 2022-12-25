package raywenderlich.queue.basicQueue

/**
 * - Queues use FIFO (first in, first out) ordering, meaning the first element that
 * was added will always be the first one removed. Queues are handy when you need to
 * maintain the order of your elements to process later.
 *
 * - NOTE: the queue only cares about removal from the front and insertion at the back.
 * You don't need to know what the contents are in between. If you did, you'd
 * presumably use an array instead of a Queue.
 *
 * - You can create a Queue in four different ways:
 * (1) Using an array based list
 * (2) Using a doubly linked list
 * (3) Using a ring buffer
 * (4) Using two stacks
 */
interface MyQueueInterface<T> {

    val count: Int

    /**
     * Checks if the queue is empty using the [MyQueueInterface.count] property
     */
    val isEmpty: Boolean
        get() = count == 0

    /**
     * Inserts an element at the back of the queue and returns true if the
     * operation is successful
     */
    fun enqueue(element: T): Boolean

    /**
     * Removes the element at the front of the queue and returns it
     */
    fun dequeue(): T?

    /**
     * Returns the element at the front of the queue without removing it
     */
    fun peek(): T?

}