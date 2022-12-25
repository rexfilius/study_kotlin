package raywenderlich.arrays.sort.nSquaredSorts

import raywenderlich.util.swapIndexInList

/**
 * - Insertion sort is a more useful algorithm. Like bubble sort and selection sort,
 * insertion sort has an average time complexity of O(n²), but the performance of
 * insertion sort can vary. The more the data is already sorted, the less work it needs
 * to do. Insertion sort has best time complexity of O(n) if the data is already sorted.
 * - Insertion sort is one of the fastest sorting algorithms when some data is already
 * sorted, but this isn't true for all sorting algorithms.
 * - In practice, a lot of data collections will already be mostly — if not entirely
 * — sorted, and an insertion sort will perform quite well in those scenarios
 */
fun <T : Comparable<T>> MutableList<T>.myInsertionSort(showPasses: Boolean = false) {

    if (this.size < 2) return

    // Insertion sort requires you to iterate from left to right, once.
    // This loop does that.
    for (current in 1 until this.size) {
        // Here, you run backward from the current index,
        // so you can shift left as needed.
        for (shifting in (1..current).reversed()) {
            // Keep shifting the element left as long as necessary. As soon as the
            // element is in position, break the inner loop
            // and start with the next element.
            if (this[shifting] < this[shifting - 1]) {
                this.swapIndexInList(shifting, shifting - 1)
            } else break
        }

        // You can remove this and the parameter, it just prints the steps
        if (showPasses) println(this)
    }
}