package raywenderlich.arrays.sort.otherSorts.quickSort

import raywenderlich.util.swapIndexInList

fun <T : Comparable<T>> MutableList<T>.quickSortHoare(low: Int, high: Int) {
    if (low < high) {
        val pivot = this.partitionHoare(low, high)
        this.quickSortHoare(low, pivot)
        this.quickSortHoare(pivot + 1, high)
    }
}

/**
 * - Hoare's partitioning algorithm always chooses the first element as the pivot
 * - Note: The index returned from the partition does not necessarily have to be
 * the index of the pivot element.
 */
fun <T : Comparable<T>> MutableList<T>.partitionHoare(low: Int, high: Int): Int {
    // Select the first element as the pivot.
    val pivot = this[low]

    // Indexes i and j define two regions. Every index before i will be less than or
    //equal to the pivot. Every index after j will be greater than
    // or equal to the pivot.
    var i = low - 1
    var j = high + 1

    while (true) {
        // Decrease j until it reaches an element that is not greater than the pivot.
        do {
            j -= 1
        } while (this[j] > pivot)
        // Increase i until it reaches an element that is not less than the pivot.
        do {
            i += 1
        } while (this[i] < pivot)
        // If i and j have not overlapped, swap the elements
        // Return the index that separates both regions.
        if (i < j) this.swapIndexInList(i, j)
        else return j
    }
}