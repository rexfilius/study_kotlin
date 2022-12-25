package raywenderlich.arrays.sort.nSquaredSorts

import raywenderlich.util.swapIndexInList

/**
 * - Selection sort follows the basic idea of bubble sort but improves upon this
 * algorithm by reducing the number of [swapIndexInList] operations. Selection sort only swaps
 * at the end of each pass.
 * - Like bubble sort, selection sort has worst and average time complexity of
 * O(n²), Unlike the bubble sort, it also has the best time complexity of O(n²).
 * - Despite this, it performs better than bubble sort because it performs only
 * O(n) swaps, and the algorithm is quite a simple one to understand.
 */
fun <T : Comparable<T>> MutableList<T>.mySelectionSort(showPasses: Boolean = false) {

    if (this.size < 2) return

    // Perform a pass for every element in the collection, except for the last one.
    // There's no need to include the last element because if all other elements are
    // in their correct order, the last one will be as well
    for (current in indices) {     // this.indices or 0 until lastIndex
        var lowest = current
        // In every pass, you go through the remainder of the collection to find the
        // element with the lowest value.
        for (other in (current + 1) until this.size) {
            if (this[lowest] > this[other])
                lowest = other
        }
        // If the lowest element is not the current element, swap them.
        if (lowest != current) this.swapIndexInList(lowest, current)

        // You can remove this and the parameter, it just prints the steps
        if (showPasses) println(this)
    }
}