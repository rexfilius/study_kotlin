package raywenderlich.heap

import raywenderlich.util.example

fun main() {
    "Creating a Heap" example {
        val array = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7)
        val priorityQueue = MyHeapComparable.create(array)

        // remove and print the max value until the Heap is empty
        while (!priorityQueue.isEmpty)
            println(priorityQueue.remove())
    }

    "Finding the max in an array" example {
        val iArray = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7)
        val iHeap = MyHeapComparable.create(iArray)
        println("Array: $iArray")
        println("Maximum element: ${iHeap.peek()}")
    }

    "Creating a min-Heap" example {
        val bArray = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7)
        val minHeap = MyHeapComparator.create(
            elements = bArray, comparator = inverseComparator
        )

        // remove and print the value with the lowest priority until the Heap is empty
        while (!minHeap.isEmpty)
            println(minHeap.remove())
    }
}

val inverseComparator = Comparator<Int> { o1, o2 -> o2.compareTo(o1) }