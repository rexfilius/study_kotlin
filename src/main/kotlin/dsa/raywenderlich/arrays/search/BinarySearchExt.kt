package raywenderlich.arrays.search

/**
 * - Write a function that searches a sorted ArrayList and finds the range of
 * indices for a particular element
 * - [findIndicesExt] is an unoptimized but elegant solution. The time complexity of
 * this solution is O(n), which may not seem to be a cause for concern. However, you
 * can optimize the solution to an O(log n) time complexity solution.
 * [findIndicesExt2] is a better optimized solution
 */
fun <T : Comparable<T>> ArrayList<T>.findIndicesExt(value: T): IntRange? {
    val startIndex = indexOf(value)
    val endIndex = lastIndexOf(value)

    if (startIndex == -1 || endIndex == -1)
        return null

    return startIndex..endIndex
}

/**
 * - [findIndicesExt2] uses specialized binary searches. startIndex and endIndex
 * will be the ones that do the heavy lifting with a customized binary search.
 */
fun <T : Comparable<T>> ArrayList<T>.findIndicesExt2(value: T): IntRange? {
    val startIndex = startIndex(value, 0..size) ?: return null
    val endIndex = endIndex(value, 0..size) ?: return null
    return startIndex until endIndex
}

private fun <T : Comparable<T>> ArrayList<T>.startIndex(
    value: T,
    range: IntRange
): Int? {
    // calculate the middle value of the indices contained in range.
    val middleIndex = range.first + (range.last - range.first + 1) / 2

    // Base case of this recursive function. If the middle index is the first or last
    // accessible index of the array, you don't need to call binary search any further.
    // You'll determine whether the current index is a valid bound for the given value.
    if (middleIndex == 0 || middleIndex == size - 1) {
        return if (this[middleIndex] == value) middleIndex
        else null
    }

    // Here, you check the value at the index and make your recursive calls. If the
    // value at middleIndex is equal to the value you're given, you check to see if
    // the predecessor is also the same value. If it isn't, you know that you've found
    // the starting bound. Otherwise, you'll continue by recursively calling startIndex.
    return if (this[middleIndex] == value) {
        if (this[middleIndex - 1] != value) {
            middleIndex
        } else {
            startIndex(value, range.first until middleIndex)
        }
    } else if (value < this[middleIndex]) {
        startIndex(value, range.first until middleIndex)
    } else {
        startIndex(value, (middleIndex + 1)..range.last)
    }

}

private fun <T : Comparable<T>> ArrayList<T>.endIndex(
    value: T,
    range: IntRange
): Int? {
    val middleIndex = range.first + (range.last - range.first + 1) / 2

    if (middleIndex == 0 || middleIndex == size - 1) {
        return if (this[middleIndex] == value) middleIndex + 1
        else null
    }

    return if (this[middleIndex] == value) {
        if (this[middleIndex + 1] != value) {
            middleIndex + 1
        } else {
            endIndex(value, (middleIndex + 1)..range.last)
        }
    } else if (value < this[middleIndex]) {
        endIndex(value, range.first until middleIndex)
    } else {
        endIndex(value, (middleIndex + 1)..range.last)
    }
}