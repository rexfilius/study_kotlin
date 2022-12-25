package raywenderlich.arrays.sort.otherSorts

/**
 * - Write a function that takes two sorted iterables and merges them into a
 * single iterable.
 * - The tricky part of this challenge is the limited capabilities of Iterable.
 * Traditional implementations of this algorithm rely on the abilities of List types
 * to keep track of indices. Since Iterable types have no notion of indices,
 * you'll make use of their iterator.
 */
fun <T : Comparable<T>> mergeIterables(
    first: Iterable<T>,
    second: Iterable<T>
): Iterable<T> {

    // Create a new container to store the merged iterable. It could be any class
    // that implements Iterable but a MutableList is an easy-to-use choice.
    val result = mutableListOf<T>()
    val firstIterator = first.iterator()
    val secondIterator = second.iterator()

    // Create two variables that are initialized as the first and second
    // iterators' first value.
    if (!firstIterator.hasNext()) return second
    if (!secondIterator.hasNext()) return first

    // If one of the iterators didn't have a first value, it means the iterable it
    // came from was empty, and you're done sorting. Simply return the other iterable.
    var firstEl = firstIterator.nextOrNull()
    var secondEl = secondIterator.nextOrNull()

    // This first while loop is where all the comparisons are made to get the
    // resulting iterable ordered. It only works while you still have values
    // in both iterables.
    while (firstEl != null && secondEl != null) {
        when {
            // If the first value is less than the second, you'll append the first
            // value in result and seed the next value to be compared with by invoking
            // nextOrNull() on the first iterator.
            firstEl < secondEl -> {
                result.add(firstEl)
                firstEl = firstIterator.nextOrNull()
            }
            // If the second value is less than the first, you’ll do the opposite.
            // You seed the next value to be compared by invoking nextOrNull()
            // on the second iterator.
            secondEl < firstEl -> {
                result.add(secondEl)
                secondEl = secondIterator.nextOrNull()
            }
            // If they're equal, you append both the first and second values
            // and seed both next values.
            else -> {
                result.add(firstEl)
                result.add(secondEl)
                firstEl = firstIterator.nextOrNull()
                secondEl = secondIterator.nextOrNull()
            }
        }
    }

    // The loop above will continue until one of the iterators runs out of elements
    // to dispense. In that scenario, the iterator with elements left only has
    // elements that are equal to or greater than the current values in result.
    // Then you add the rest of those values
    while (firstEl != null) {
        result.add(firstEl)
        firstEl = firstIterator.nextOrNull()
    }
    while (secondEl != null) {
        result.add(secondEl)
        secondEl = secondIterator.nextOrNull()
    }
    return result
}

private fun <T> Iterator<T>.nextOrNull(): T? {
    return if (this.hasNext()) this.next() else null
}

