package raywenderlich.queue.basicQueue

class QueueOnRingBuffer<T>(size: Int) : MyQueueInterface<T> {

    private val ringBuffer: MyRingBuffer<T> = MyRingBuffer(size)

    override val count: Int
        get() = ringBuffer.count

    /**
     * O(1) time complexity
     */
    override fun enqueue(element: T): Boolean {
        return ringBuffer.write(element)
    }

    /**
     * O(1) time complexity
     */
    override fun dequeue(): T? {
        return if (isEmpty) null
        else ringBuffer.read()
    }

    override fun peek(): T? {
        return ringBuffer.first
    }

    override fun toString(): String = ringBuffer.toString()
}