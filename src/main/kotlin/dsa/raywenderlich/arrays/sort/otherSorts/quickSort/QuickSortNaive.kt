package raywenderlich.arrays.sort.otherSorts.quickSort

/**
 * - This implementation recursively filters the list into three partitions.
 * - While this naive implementation is easy to understand, it raises some issues
 * and questions:
 * (1) Calling filter three times on the same list is not efficient?
 * (2) Creating a new list for every partition isn't space-efficient.
 * Could you possibly sort in place?
 * (3) Is picking the middle element the best pivot strategy?
 * What pivot strategy should you adopt?
 */
fun <T : Comparable<T>> List<T>.quickSortNaive(): List<T> {
    // There must be more than one element in the list.
    // If not, the list is considered sorted
    if (this.size < 2) return this

    // Pick the middle element of the list as your pivot.
    val pivot = this[this.size / 2]

    // Using the pivot, split the original list into three partitions. Elements less
    // than, equal to or greater than the pivot go into different buckets.
    val less = this.filter { it < pivot }
    val equal = this.filter { it == pivot }
    val greater = this.filter { it > pivot }

    // Recursively sort the partitions and then combine them.
    return less.quickSortNaive() + equal + greater.quickSortNaive()
}