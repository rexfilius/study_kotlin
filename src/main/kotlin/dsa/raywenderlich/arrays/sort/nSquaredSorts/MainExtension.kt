package raywenderlich.arrays.sort.nSquaredSorts

import raywenderlich.util.swapIndexInList

/**
 * - Given a list of Comparable elements, bring all instances of a given value in the
 * list to the right side of the array.
 * - The trick to this problem is to find the elements that need to be moved and shift
 * everything else to the left. Then, return to the position where the element was
 * before, and continue searching from there.
 */
fun <T : Comparable<T>> MutableList<T>.rightAlign(element: T) {
    // If there are less than two elements in the list, there’s nothing to do.
    if (this.size < 2) return

    // You leave the last element alone and start from the previous one. Then, you go
    // to the left (decreasing the index), until you reach the beginning of the list
    // when the searchIndex is 0.
    var searchIndex = this.size - 2
    while (searchIndex >= 0) {
        // Looking for elements that are equal to the one in the function parameter.
        if (this[searchIndex] == element) {

            // Whenever you find one, you start shifting it to the right until you
            // reach another element equal to it or the end of the list.
            var moveIndex = searchIndex
            while (moveIndex < lastIndex && this[moveIndex + 1] != element) {
                swapIndexInList(moveIndex, moveIndex + 1)
                moveIndex++
            }
        }
        // After you're done with that element, move searchIndex to the left again
        // by decrementing it.
        searchIndex--
    }
}

/**
 * - Given a list of Comparable elements, return the largest element that's a
 * duplicate in the list.
 */
fun <T : Comparable<T>> MutableList<T>.biggestDuplicate(): T? {
    // You first sort the list.
    this.mySelectionSort()
    // println(this) // just a place holder

    // Start going through it from right to left since you know that the biggest
    // elements are on the right, neatly sorted.
    for (index in (1 until this.size).reversed()) {
        // The first one that’s repeated is your solution.
        if (this[index] == this[index - 1])
            return this[index]
    }

    // if you go through all the elements and none of them are repeated,
    //you can return null
    return null
}

/**
 * - Reverse a list of elements manually
 */
fun <T : Comparable<T>> MutableList<T>.reverseList() {
    var leftIndex = 0
    var rightIndex = lastIndex

    while (leftIndex < rightIndex) {
        swapIndexInList(leftIndex, rightIndex)
        leftIndex++
        rightIndex--
    }
}