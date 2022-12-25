package raywenderlich.arrays.sort.otherSorts

/**
 * - Radix sort is a non-comparative algorithm for sorting integers in linear time.
 * - There are many implementations of radix sort that focus on different problems.
 * To keep things simple, this implementation focuses on sorting base 10 integers
 * while investigating the least significant digit (LSD) variant of radix sort.
 * - Radix sort is one of the fastest sorting algorithms. The average time complexity
 * is O(k × n), where k is the number of significant digits of the largest number,
 * and n is the number of integers in the list.
 * - Radix sort works best when k is constant, which occurs when all numbers in the
 * list have the same count of significant digits. Its time complexity then becomes
 * O(n). Radix sort also incurs an O(n) space complexity, as you need space to store
 * each bucket.
 */
fun MutableList<Int>.myRadixSort() {
    // You're sorting base 10 integers in this instance. Since you'll use this value
    // many times in the algorithm, you store it in a constant base.
    val base = 10

    // You declare two variables to track your progress. Radix sort works in many
    // passes, 'done' serves as a flag that determines whether the sort is complete.
    // The digits variable keeps track of the current digit you're looking at.
    var done = false
    var digits = 1

    while (!done) {
        done = true
        // You instantiate the buckets using a two-dimensional list. Because you're
        // using base 10, you need ten buckets.
        val buckets = arrayListOf<MutableList<Int>>().apply {
            for (i in 0..9)
                this.add(arrayListOf())
        }
        // You place each number in the correct bucket.
        this.forEach { number ->
            val remainingPart = number / digits
            val digit = remainingPart % base
            buckets[digit].add(number)
            if (remainingPart > 0) done = false
        }
        // You update digits to the next digit you want to inspect and update the
        // list using the contents of buckets. flatten() flattens the 2-D list to a
        // 1-D list, as if you're emptying the buckets into the list.
        digits *= base
        this.clear()
        this.addAll(buckets.flatten())
    }
}