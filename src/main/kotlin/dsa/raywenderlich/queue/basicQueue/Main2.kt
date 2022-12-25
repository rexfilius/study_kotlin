package raywenderlich.queue.basicQueue

import raywenderlich.util.example

fun main() {

    "Boardgame manager with Queue" example {
        val queue = QueueOnArrayList<String>().apply {
            enqueue("Vincent")
            enqueue("Remel")
            enqueue("Lukiih")
            enqueue("Allison")
        }
        println(queue)

        println("===== boardgame =======")
        queue.nextPlayer()
        println(queue)
        queue.nextPlayer()
        println(queue)
        queue.nextPlayer()
        println(queue)
        queue.nextPlayer()
        println(queue)
    }

    "Reversing a queue" example {
        val queue = QueueOnArrayList<String>().apply {
            enqueue("1")
            enqueue("21")
            enqueue("18")
            enqueue("42")
        }
        println("before: $queue")
        queue.reverse()
        println("after: $queue")
    }
}