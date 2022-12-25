package raywenderlich.queue.priorityQueue

import java.util.Collections

class MyArrayListPriorityQueueComparable<T : Comparable<T>>
    : MyArrayListPriorityQueue<T>() {

    override fun sort() {
        elements.sort()    // or Collections.sort(elements)
    }
}

class MyArrayListPriorityQueueComparator<T>(
    private val comparator: Comparator<T>
) : MyArrayListPriorityQueue<T>() {

    override fun sort() {
        Collections.sort(elements, comparator)
    }
}

class MyArrayListPriorityQueueCustom<T : Comparable<T>>
    : MyArrayListPriorityQueue<T>() {

    /**
     * This is an O(n) operation since you have to shift the existing elements to
     * the left by one until you find the right position.
     */
    override fun sort() {
        var index = count - 2
        while (index >= 0 && elements[index + 1].compareTo(elements[index]) > 0) {
            swap(index, index + 1)
            index--
        }
    }

    private fun swap(i: Int, j: Int) {
        val temp = elements[i]
        elements[i] = elements[j]
        elements[j] = temp
    }
}