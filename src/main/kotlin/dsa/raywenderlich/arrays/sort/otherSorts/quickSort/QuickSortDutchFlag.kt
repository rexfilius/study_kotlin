package raywenderlich.arrays.sort.otherSorts.quickSort

import raywenderlich.util.swapIndexInList

/**
 * - A problem with Lomuto and Hoare algorithms is that they don't handle duplicates
 * really well. With Lomuto algorithm, duplicates end up in the less than partition
 * and aren't grouped together.
 * - With Hoare algorithm, the situation is even worse, as duplicates can be all over
 * the place. A solution to organize duplicate elements is using Dutch national flag
 * partitioning.
 */
fun <T : Comparable<T>> MutableList<T>.quickSortDutchFlag(low: Int, high: Int) {
    if (low < high) {
        val middle = partitionDutchFlag(low, high, high)
        this.quickSortDutchFlag(low, middle.first - 1)
        this.quickSortDutchFlag(middle.second + 1, high)
    }
}

/**
 * Here, you adopt the same strategy as Lomuto’s partition by choosing the last
 * element as the pivotIndex
 */
fun <T : Comparable<T>> MutableList<T>.partitionDutchFlag(
    low: Int,
    high: Int,
    pivotIndex: Int
): Pair<Int, Int> {
    val pivot = this[pivotIndex]
    // Whenever you encounter an element that is less than the pivot, move it to
    // index smaller. This means that all elements that come before this index are
    // less than the pivot.
    var smaller = low
    // Index equal points to the next element to compare. Elements that are equal to
    // the pivot are skipped, which means that all elements between smaller and
    // equal are equal to the pivot.
    var equal = low
    // Whenever you encounter an element that is greater than the pivot, move it to
    // index larger. This means that all elements that come after this index are
    // greater than the pivot.
    var larger = high

    // The main loop compares elements and swaps them if needed. This continues
    //until index equal moves past index larger, meaning all elements have been
    //moved to their correct partition.
    while (equal <= larger) {
        when {
            this[equal] < pivot -> {
                this.swapIndexInList(smaller, equal)
                smaller += 1
                equal += 1
            }

            this[equal] == pivot -> equal += 1

            else -> {
                this.swapIndexInList(equal, larger)
                larger -= 1
            }
        }
    }
    // The algorithm returns indices smaller and larger. These point to the first
    // and last elements of the middle partition.
    return Pair(smaller, larger)
}