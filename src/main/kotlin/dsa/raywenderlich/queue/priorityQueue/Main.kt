package raywenderlich.queue.priorityQueue

import raywenderlich.util.example

fun main() {
    "max priority queue" example {
        val priorityQueue = MyPriorityQueueComparable<Int>()
        arrayListOf(1, 12, 3, 4, 1, 6, 8, 7).forEach {
            priorityQueue.enqueue(it)
        }
        while (!priorityQueue.isEmpty)
            println(priorityQueue.dequeue())
    }

    "min priority queue" example {
        val bPriorityQueue = MyPriorityQueueComparator(stringLengthComparator)
        arrayListOf(
            "one", "two", "three", "forty", "five", "six",
            "seven", "eight", "nine"
        ).forEach {
            bPriorityQueue.enqueue(it)
        }
        while (!bPriorityQueue.isEmpty)
            println(bPriorityQueue.dequeue())
    }

    "max priority array list based queue" example {
        val cPriorityQueue = MyArrayListPriorityQueueCustom<Int>()
        arrayListOf(1, 12, 3, 4, 1, 6, 8, 7).forEach {
            cPriorityQueue.enqueue(it)
        }
        cPriorityQueue.enqueue(5)
        cPriorityQueue.enqueue(0)
        cPriorityQueue.enqueue(10)
        while (!cPriorityQueue.isEmpty)
            println(cPriorityQueue.dequeue())
    }

    "concert line" example {
        val p1 = PersonToSort("Josh", 21, true)
        val p2 = PersonToSort("Jake", 22, true)
        val p3 = PersonToSort("Clay", 28, false)
        val p4 = PersonToSort("Cindy", 28, false)
        val p5 = PersonToSort("Sabrina", 30, false)

        val dPriorityQueue = MyPriorityQueueComparator(MilitaryPersonComparator)
        arrayListOf(p1, p2, p3, p4, p5).forEach {
            dPriorityQueue.enqueue(it)
        }
        while (!dPriorityQueue.isEmpty)
            println(dPriorityQueue.dequeue())
    }
}

val stringLengthComparator = Comparator<String> { o1, o2 ->
    val length1 = o1?.length ?: -1
    val length2 = o2?.length ?: -1
    length1 - length2
}