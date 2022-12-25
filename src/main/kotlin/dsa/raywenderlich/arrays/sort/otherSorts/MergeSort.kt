package raywenderlich.arrays.sort.otherSorts

/**
 * - Merge sort is one of the most efficient sorting algorithms. With a time complexity
 * of O(n log n), it's one of the fastest of all general-purpose sorting algorithms.
 * - The idea behind merge sort is divide and conquer — to break a big problem into
 * several smaller, easier-to-solve problems, and then combine those solutions into a
 * final result. The merge sort mantra is to split first and merge after.
 * - When it comes to sorting algorithms, any list that's shorter than two elements
 * is already sorted
 */
fun <T : Comparable<T>> List<T>.myMergeSort(): List<T> {
    // base case for the recursion i.e. an "exit condition".
    // In this case, the base case is when the list only has one element
    if (this.size < 2) return this

    // Call mergeSort on each of the sub-lists. This recursion continues to try
    // to split the lists into smaller lists until the "exit condition" is fulfilled
    val middle = this.size / 2
    val left = this.subList(fromIndex = 0, toIndex = middle).myMergeSort()
    val right = this.subList(fromIndex = middle, toIndex = this.size).myMergeSort()

    return merge(leftList = left, rightList = right)
}

/**
 * - The sole responsibility of this merge function is to take in two sorted lists
 * and combine them while retaining the sort order.
 */
private fun <T : Comparable<T>> merge(leftList: List<T>, rightList: List<T>): List<T> {
    // The leftIndex and rightIndex variables track your progress
    // as you parse through the two lists
    var leftIndex = 0
    var rightIndex = 0

    // The result list will house the combined lists.
    val result = mutableListOf<T>()

    // Starting from the beginning, you compare the elements in the left and right
    // lists sequentially. When you reach the end of either list, there's nothing
    // else to compare.
    while (leftIndex < leftList.size && rightIndex < rightList.size) {
        val leftElement = leftList[leftIndex]
        val rightElement = rightList[rightIndex]

        // The smaller of the two elements goes into the result list. If the elements
        // are equal, they can both be added.
        when {
            leftElement < rightElement -> {
                result.add(leftElement)
                leftIndex += 1
            }
            leftElement > rightElement -> {
                result.add(rightElement)
                rightIndex += 1
            }
            else -> {
                result.add(leftElement)
                leftIndex += 1
                result.add(rightElement)
                rightIndex += 1
            }
        }
    }

    // The first loop guarantees that either left or right is empty. Since both lists
    // are sorted, this ensures that the leftover elements are greater than or equal
    // to the ones currently in result. In this scenario, you can add the rest of the
    // elements without comparison.
    if (leftIndex < leftList.size) {
        result.addAll(leftList.subList(leftIndex, leftList.size))
    }
    if (rightIndex < rightList.size) {
        result.addAll(rightList.subList(rightIndex, rightList.size))
    }
    return result
}