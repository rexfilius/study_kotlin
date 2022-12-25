package raywenderlich.arrays.sort.otherSorts.quickSort

import raywenderlich.stack.Stack
import raywenderlich.util.swapIndexInList

/**
 * - Here, you apply Lomuto's algorithm to partition the list into two regions. You
 * then recursively sort these regions. Recursion ends once a region has less than
 * two elements.
 */
fun <T : Comparable<T>> MutableList<T>.quickSortLomuto(low: Int, high: Int) {
    if (low < high) {
        val pivot = this.partitionLomuto(low, high)
        this.quickSortLomuto(low, pivot - 1)
        this.quickSortLomuto(pivot + 1, high)
    }
}

/**
 * - Lomuto's partitioning algorithm for quick sort always chooses the last element
 * as the pivot.
 * - @param(low, high) - set the range within the list you'll partition. This range
 * will get smaller and smaller with every recursion.
 */
fun <T : Comparable<T>> MutableList<T>.partitionLomuto(low: Int, high: Int): Int {
    // Set the pivot. Lomuto always chooses the last element as the pivot.
    val pivot = this[high]

    // The variable i indicates how many elements are less than the pivot. Whenever
    // you encounter an element that is less than the pivot, you swap it with the
    // element at index i and increase i.
    var i = low

    // Loop through all the elements from low to high, but not including high since
    // it's the pivot.
    for (j in low until high) {
        // Check to see if the current element is less than or equal to the pivot.
        if (this[j] <= pivot) {
            // If it is, swap it with the element at index i and increase i.
            this.swapIndexInList(i, j)
            i += 1
        }
    }
    // Once done with the loop, swap the element at i with the pivot. The pivot
    // always sits between the less and greater partitions.
    this.swapIndexInList(i, high)
    // Return the index of the pivot.
    return i
}

fun <T : Comparable<T>> MutableList<T>.quickSortLomutoIterative(
    low: Int, high: Int
) {
    // Create a stack that stores indices.
    val stack = Stack<Int>()
    // Push the starting low and high boundaries on the stack
    // to initiate the algorithm.
    stack.push(low)
    stack.push(high)

    // As long as the stack is not empty, quicksort is not complete
    while (!stack.isEmpty) {
        // Get the pair of start and end indices from the stack
        val end = stack.pop() ?: continue
        val start = stack.pop() ?: continue

        // Perform Lomuto partitioning with the current start and end index. Lomuto
        // picks the last element as the pivot, and splits the partitions into three
        // parts: elements that are less than the pivot, the pivot, and finally
        // elements that are greater than the pivot
        val p = this.partitionLomuto(start, end)
        // Once the partitioning is complete, check and add the lower bound's start
        // and end indices to later partition the lower half.
        if ((p - 1) > start) {
            stack.push(start)
            stack.push(p - 1)
        }
        // Similarly, check and add the upper bound’s start and end indices to
        // later partition the upper half.
        if ((p + 1) < end) {
            stack.push(p + 1)
            stack.push(end)
        }
    }
}