package raywenderlich.queue.basicQueue

/**
 * - Can you eliminate allocation overhead and preserve O(1) dequeues? If you don’t
 * have to worry about your queue growing beyond a fixed size, you can use a
 * different approach like the ring buffer.
 * - For raywenderlich.util.example, you might have a game of Monopoly with five players. You can use a
 * queue based on a ring buffer to keep track of whose turn is coming up next.
 * - A ring buffer, also known as a circular buffer, is a fixed-size array. This data
 * structure strategically wraps around to the beginning when there are no more
 * items to remove at the end.
 */
class MyRingBuffer<T>(private val size: Int) {

    private var array = ArrayList<T?>(size)

    // The read pointer keeps track of the front of the queue.
    private var readIndex = 0

    // The 'write' pointer keeps track of the next available slot so that you can
    // override existing elements that have already been read.
    private var writeIndex = 0

    private val availableSpaceForReading: Int
        get() = (writeIndex - readIndex)

    private val availableSpaceForWriting: Int
        get() = (size - availableSpaceForReading)

    val count: Int
        get() = availableSpaceForReading

    val first: T?
        get() = array.getOrNull(readIndex)

    /**
     * Whenever the read and write pointers are at the
     * same index, that means the queue is empty.
     */
    val isEmpty: Boolean
        get() = (count == 0)

    val isFull: Boolean
        get() = (availableSpaceForWriting == 0)

    fun write(element: T): Boolean {
        return if (!isFull) {
            if (array.size < size) {
                array.add(element)
            } else {
                array[writeIndex % size] = element
            }
            writeIndex += 1
            true
        } else {
            false
        }
    }

    fun read(): T? {
        return if (!isEmpty) {
            val element = array[readIndex % size]
            readIndex += 1
            element
        } else {
            null
        }
    }

    override fun toString(): String {
        val values = (0 until availableSpaceForReading).map { offset ->
            "${array[(readIndex + offset) % size]!!}"
        }
        return values.joinToString(prefix = "[", separator = ", ", postfix = "]")
    }
}