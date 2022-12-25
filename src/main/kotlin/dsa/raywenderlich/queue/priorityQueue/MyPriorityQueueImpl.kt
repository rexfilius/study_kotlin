package raywenderlich.queue.priorityQueue

import raywenderlich.heap.MyHeapInterface
import raywenderlich.heap.MyHeapComparable
import raywenderlich.heap.MyHeapComparator

class MyPriorityQueueComparable<T : Comparable<T>> : MyPriorityQueue<T>() {

    override val heap: MyHeapInterface<T> = MyHeapComparable()
}

class MyPriorityQueueComparator<T>(
    comparator: Comparator<T>
) : MyPriorityQueue<T>() {

    override val heap: MyHeapInterface<T> = MyHeapComparator(comparator)
}