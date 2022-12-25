package raywenderlich.arrays.sort.otherSorts

import raywenderlich.util.swapIndexInArray
import kotlin.Comparator

/**
 * - Heapsort is another comparison-based algorithm that sorts an array in ascending
 * order using a heap.
 * - Heapsort takes advantage of a heap being, by definition, a partially sorted
 * binary tree with the following qualities:
 * (1) In a max heap, all parent nodes are larger than their children.
 * (2) In a min heap, all parent nodes are smaller than their children.
 * - Even though you get the benefit of in-memory sorting, the performance of heap
 * sort is O(n log n) for its best, worse and average cases. This is because you have
 * to traverse the whole array once and, every time you swap elements, you must
 * perform a sift down, which is an O(log n) operation.
 * - Heap sort is also not a stable sort because it depends on how the elements are
 * laid out and put into the heap. If you were heap-sorting a deck of cards by their
 * rank, e.g. you might see their suite change order with respect to the original deck.
 */
fun <T> Array<T>.myHeapSort(comparator: Comparator<T>) {
    // reorder the elements so that the array looks like a Heap.
    this.heapify(comparator)
    // loop through the array, starting from the last element.
    for (index in this.indices.reversed()) {
        // You swap the first element and the last element. This moves the largest
        // unsorted element to its correct spot.
        this.swapIndexInArray(0, index)
        // Because the heap is now invalid, you must sift down the new root node.
        // As a result, the next largest element will become the new root.
        siftDown(index = 0, upTo = index, comparator)
    }
}

/**
 * this function is inspired from [heap.MyHeap.heapify] in MyHeap.Kt
 */
fun <T> Array<T>.heapify(comparator: Comparator<T>) {
    if (this.isNotEmpty()) {
        (this.size / 2 downTo 0).forEach {
            this.siftDown(index = it, upTo = this.size, comparator)
        }
    }
}

/**
 * this function is inspired from [heap.MyHeap.siftDown] in the MyHeap.Kt file
 */
fun <T> Array<T>.siftDown(index: Int, upTo: Int, comparator: Comparator<T>) {
    // Store the parent index.
    var parent: Int = index

    // Continue sifting until you return.
    while (true) {
        // Get the parent’s left and right child index.
        val left = leftChildIndex(parent)
        val right = rightChildIndex(parent)

        // candidate is used to keep track of which index
        // to swap with the parent.
        var candidate = parent

        // If there's a left child, and it has a higher priority
        // than its parent, make it the candidate
        if (left < upTo && comparator.compare(this[left], this[candidate]) > 0)
            candidate = left

        // If there's a right child, and it has an even greater priority,
        // it will become the candidate instead.
        if (right < upTo && comparator.compare(this[right], this[candidate]) > 0)
            candidate = right

        // If candidate is still parent, you have reached the end,
        // and no more sifting is required.
        if (candidate == parent) return

        // Swap candidate with parent and set it as the new parent
        // to continue sifting.
        this.swapIndexInArray(parent, candidate)
        parent = candidate
    }
}

private fun leftChildIndex(index: Int) = (2 * index) + 1

private fun rightChildIndex(index: Int) = (2 * index) + 2