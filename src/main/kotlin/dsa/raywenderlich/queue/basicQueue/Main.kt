package raywenderlich.queue.basicQueue

import raywenderlich.util.example

fun main() {

    "Queue with ArrayList" example {
        val aQueue = QueueOnArrayList<String>().apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }
        println("Queue: $aQueue")

        aQueue.dequeue()
        println("Queue: dequeued: $aQueue")
        println("Next to be dequeued: ${aQueue.peek()}")
    }

    "Queue with DoublyLinkedList" example {
        val bQueue = QueueOnLinkedList<String>().apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }

        println("Queue: $bQueue")
        bQueue.dequeue()
        println("Queue: dequeued: $bQueue")
        println("Next to be dequeued: ${bQueue.peek()}")
    }

    "Queue with RingBuffer" example {
        val cQueue = QueueOnRingBuffer<String>(10).apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }

        println("Queue: $cQueue")
        cQueue.dequeue()
        println("Queue: dequeued: $cQueue")
        println("Next to be dequeued: ${cQueue.peek()}")
    }

    "Queue with Double Stack" example {
        val fQueue = QueueOnStack<String>().apply {
            enqueue("Ray")
            enqueue("Brian")
            enqueue("Eric")
        }
        println("Queue: $fQueue")
        fQueue.dequeue()
        println("Queue - dequeued: $fQueue")
        println("Next to be dequeued: ${fQueue.peek()}")
    }

}