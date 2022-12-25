package raywenderlich.arrays.sort.otherSorts.quickSort

import raywenderlich.util.swapIndexInList

/**
 * This is a variation on quicksortLomuto that adds a median of three as a first step.
 */
fun <T : Comparable<T>> MutableList<T>.quickSortMedian(low: Int, high: Int) {
    if (low < high) {
        val pivotIndex = medianOfThree(low, high)
        this.swapIndexInList(pivotIndex, high)
        val pivot = partitionLomuto(low, high)
        this.quickSortLomuto(low, pivot - 1)
        this.quickSortLomuto(pivot + 1, high)
    }
}

/*
* - Here, you find the median of this[low], this[center] and this[high] by sorting
* them. The median will end up at index center, which is what the function returns.
*/
fun <T : Comparable<T>> MutableList<T>.medianOfThree(low: Int, high: Int): Int {
    val center = (low + high) / 2
    if (this[low] > this[center]) this.swapIndexInList(low, center)
    if (this[low] > this[high]) this.swapIndexInList(low, high)
    if (this[center] > this[high]) this.swapIndexInList(center, high)
    return center
}