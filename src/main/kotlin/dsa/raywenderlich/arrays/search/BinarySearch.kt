package raywenderlich.arrays.search

/**
 * - Binary search is one of the most efficient searching algorithms with a time
 * complexity of O(log n). This is comparable with searching for an element inside
 * a balanced binary search tree.
 * - Two conditions need to be met before you can use binary search:
 * (1) The collection must be able to perform index manipulation in constant time.
 * Kotlin's collections that can do this includes the Array and the ArrayList.
 * (2) The collection must be sorted.
 * - (***) -> Binary search is recursive, so you need to be able to pass in a range
 * to search. The parameter range is made optional by giving it a default value;
 * this lets you start the search without having to specify a range. In this case,
 * the 'indices' property of ArrayList is used, which covers all valid indexes of
 * the collection.
 */
fun <T : Comparable<T>> ArrayList<T>.binarySearchExt(
    value: T,
    range: IntRange = indices    // ***
): Int? {
    // First, check if the range contains at least one element. If it doesn't,
    // the search has failed, and you return null.
    if (range.first > range.last) return null

    // Now that you're sure you have elements in the range, you find the middle
    // index in the range.
    val size = range.last - range.first + 1
    val middleIndex = range.first + size / 2

    return when {
        // You then compare the value at this index with the value you’re searching
        // for. If they match, you return the middle index.
        this[middleIndex] == value -> middleIndex

        // If not, you recursively search either the left or right half of the
        // collection, excluding the middle item in both cases.
        this[middleIndex] > value ->
            binarySearchExt(value = value, range = range.first until middleIndex)
        else ->
            binarySearchExt(value = value, range = (middleIndex + 1)..range.last)
    }
}

/**
 * Binary search is a powerful algorithm to learn, and it comes up often in
 * programming interviews. Whenever you read something along the lines of
 * "Given a sorted array...", consider using the binary search algorithm.
 *
 * Also, if you're given a problem that looks like it's going to be O(n-squared) to
 * search, consider doing some upfront sorting. With upfront sorting, you can use
 * binary searching to reduce complexity to the cost of the sort at O(n log n).
 */