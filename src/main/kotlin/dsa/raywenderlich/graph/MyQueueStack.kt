package raywenderlich.graph

import raywenderlich.queue.basicQueue.MyQueueInterface

class MyQueueStack<T> : MyQueueInterface<T> {

    private var leftStack = arrayListOf<T>()
    private var rightStack = arrayListOf<T>()

    override val count: Int = leftStack.size + rightStack.size

    override fun enqueue(element: T): Boolean {
        rightStack.add(element)
        return true
    }

    override fun dequeue(): T? {
        if (rightStack.isEmpty()) return null

        if (leftStack.isEmpty()) {
            leftStack = ArrayList(rightStack.asReversed())
            rightStack = arrayListOf()
        }

        return leftStack.removeAt(leftStack.size - 1)
    }

    override fun peek(): T? {
        return if (leftStack.isNotEmpty()) leftStack.lastOrNull()
        else rightStack.firstOrNull()
    }
}