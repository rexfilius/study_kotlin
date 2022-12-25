package raywenderlich.arrays.sort.otherSorts

import kotlin.math.pow

fun MutableList<Int>.lexicographicalSort() {
    val newList = radixSortMSD(this, 0)
    this.clear()
    this.addAll(newList)
}

private fun radixSortMSD(list: MutableList<Int>, position: Int): MutableList<Int> {
    // Base case. If the position is equal or greater than the list's maxDigits,
    // you'll terminate the recursion.
    if (position >= list.maxDigits()) return list

    // Similar to LSD radix sort, you instantiate a two-dimensional list for
    // the buckets.
    val buckets = arrayListOf<MutableList<Int>>().apply {
        for (i in 0..9)
            this.add(arrayListOf())
    }
    // The priorityBucket is a special bucket that stores values with fewer digits than
    // the current position. Values that go in the priorityBucket are sorted first.
    val priorityBucket = arrayListOf<Int>()

    // For every number in the list, you find the digit of the current position and
    // place the number in the appropriate bucket.
    list.forEach { number ->
        val digit = number.digit(position)
        if (digit == null) {
            priorityBucket.add(number)
            return@forEach
        }
        buckets[digit].add(number)
    }
    // Next, you recursively apply MSD radix sort for each of the individual buckets.
    // This statement calls reduce(into:) to collect the results of the recursive
    // sorts and appends them to the priorityBucket. That way, the elements in the
    // priorityBucket always go first
    val newValues = buckets.reduce { result, bucket ->
        if (bucket.isEmpty()) return@reduce result
        result.addAll(radixSortMSD(bucket, position + 1))
        result
    }
    priorityBucket.addAll(newValues)
    return priorityBucket
}

private fun MutableList<Int>.maxDigits(): Int {
    return this.maxOrNull()?.digits() ?: 0
}

/**
 * digits is a computed property that returns the number of digits that the Int has.
 * For raywenderlich.util.example, the value of 1024 has four digits.
 */
fun Int.digits(): Int {
    var count = 0
    var num = this
    while (num != 0) {
        count += 1
        num /= 10
    }
    return count
}

/**
 * digit(atPosition:) returns the digit at a given position. Like lists, the leftmost
 * position is zero. Thus, the digit for position zero of the value 1024 is 1. The
 * digit for position three is 4. Since there are only four digits, the digit for
 * position five will return null.
 */
fun Int.digit(atPosition: Int): Int? {
    if (atPosition > digits()) return null
    var num = this
    val correctedPosition = (atPosition + 1).toDouble()
    while (num / (10.0.pow(correctedPosition).toInt()) != 0) {
        num /= 10
    }
    return num % 10
}