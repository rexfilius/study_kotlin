package raywenderlich.arrays.sort.nSquaredSorts

import raywenderlich.util.swapIndexInList

/**
 * - The bubble sort repeatedly compares adjacent values and swaps them, if needed,
 * to perform the sort. The larger values in the set will, therefore, bubble up to
 * the end of the collection.
 * - Bubble sort has best time complexity of O(n) if it's already sorted, and worst
 * and average time complexity of O(n²), making it one of the least appealing sorts.
 */
fun <T : Comparable<T>> MutableList<T>.myBubbleSort(showPasses: Boolean = false) {
    // There's no need to sort the collection when it has less than two elements.
    // One element is sorted by itself; zero elements don't require an order.
    if (this.size < 2) return

    // A single-pass will bubble the largest value to the end of the collection.
    // Every pass needs to compare one less value than in the previous pass, so you
    // shorten the array by one with each pass.
    for (end in (1 until this.size).reversed()) {
        var swapped = false
        // This loop performs a single pass starting from the first element and going
        // up until the last element not already sorted. It compares every element
        // with the adjacent value.
        for (current in 0 until end) {
            if (this[current] > this[current + 1]) {
                // the algorithm swaps the values if needed and marks this in swapped.
                // This is important later because it'll allow you to exit the sort as
                // early as you can detect the list is sorted.
                this.swapIndexInList(current, current + 1)
                swapped = true
            }
        }

        // This prints out how the list looks after each pass. This step has nothing
        // to do with the sorting algorithm, but it will help you visualize how it
        // works. You can remove it (and the function parameter)
        if (showPasses) println(this)

        // If no values were swapped this pass, the collection is assumed sorted,
        // and you can exit early.
        if (!swapped) return
    }
}