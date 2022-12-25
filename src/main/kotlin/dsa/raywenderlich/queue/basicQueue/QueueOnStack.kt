package raywenderlich.queue.basicQueue

import raywenderlich.stack.Stack

/**
 * - The idea behind using two stacks is simple. Whenever you enqueue an element,
 * it goes in the right stack. When you need to dequeue an element, you reverse the
 * right stack and place it in the left stack so that you can retrieve the elements
 * using FIFO order.
 * - Space complexity is O(n)
 */
class QueueOnStack<T> : MyQueueInterface<T> {

    private val leftStack = Stack<T>()
    private val rightStack = Stack<T>()

    /**
     * To check if the queue is empty, simply check that both the left and right
     * stack are empty. This means that there are no elements left to dequeue, and
     * no new elements have been enqueued.
     */
    override val isEmpty: Boolean
        get() = leftStack.isEmpty && rightStack.isEmpty

    override val count: Int
        get() = leftStack.count + rightStack.count

    override fun enqueue(element: T): Boolean {
        rightStack.push(element)
        return true
    }

    /** amortized O(1) time complexity*/
    override fun dequeue(): T? {
        if (leftStack.isEmpty) {
            transferElements()
        }
        return leftStack.pop()
    }

    /** amortized O(1) time complexity */
    override fun peek(): T? {
        if (leftStack.isEmpty) {
            transferElements()
        }
        return leftStack.peek()
    }

    override fun toString(): String {
        return "Left stack:\n$leftStack \nRight stack:\n$rightStack"
    }

    /**
     * Function to transfer the elements from the right stack into the left stack.
     * That needs to happen whenever the left stack is empty.
     */
    private fun transferElements() {
        var nextElement = rightStack.pop()
        while (nextElement != null) {
            leftStack.push(nextElement)
            nextElement = rightStack.pop()
        }
    }
}