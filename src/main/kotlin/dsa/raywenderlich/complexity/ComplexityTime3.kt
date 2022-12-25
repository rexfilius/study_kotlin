package raywenderlich.complexity

/**
 * - In linear and quadratic time complexities each element of the input is inspected
 * at least once. However, there are scenarios in which only a subset of the input
 * needs to be inspected, leading to a faster runtime.
 * - Algorithms that belong to this category of time complexity are ones that can
 * leverage some shortcuts by making some assumptions about the input data.
 * e.g. if you had a sorted list of integers, what's the quickest way to find
 * if a particular value exists?
 */
fun main() {
    val numbers = listOf(1, 3, 56, 66, 68, 80, 99, 105, 450)
    println(containsLinearForm(451, numbers))    // linear time
    println(containsLogForm(451, numbers))    // logarithmic time
}

fun containsLinearForm(value: Int, numbers: List<Int>): Boolean {
    for (element in numbers) {
        if (element == value) return true
    }
    return false
}

/**
 * - LOGARITHMIC TIME - O(log n)
 * As input data increases, the time it takes to execute the algorithm increases
 * at a slower rate.
 */
fun containsLogForm(value: Int, numbers: List<Int>): Boolean {
    if (numbers.isEmpty()) return false

    val middleIndex = numbers.size / 2

    if (value <= numbers[middleIndex]) {
        for (index in 0..middleIndex) {
            if (numbers[index] == value) return true
        }
    } else {
        for (index in middleIndex until numbers.size) {
            if (numbers[index] == value) return true
        }
    }
    return false
}

/**
 * QUASILINEAR TIME - O(n log n)
 * The Big-O notation is a multiplication of linear and logarithmic time. Algorithms
 * in this category perform worse than linear time but dramatically better than
 * quadratic time. They are among the most common algorithms you'll deal with.
 * Quasilinear is more resilient to large data sets
 * ...
 * Other time complexities do exist, but are far less common and tackle more complex
 * problems. These time complexities include:
 * Polynomial time, Exponential time, Factorial time etc.
 * ...
 * NOTE: time complexity is a high-level overview of performance, and it doesn't judge
 * the speed of the algorithm beyond the general ranking scheme. This means that two
 * algorithms can have the same time complexity, but one may still be much faster than
 * the other. For small data sets, time complexity may not be an accurate measure
 * of actual speed.
 * ...
 * For instance, quadratic algorithms such as insertion sort can be faster than
 * quasilinear algorithms, such as mergesort, if the data set is small.
 * This is because the insertion sort does not need to allocate extra memory to
 * perform the algorithm, while mergesort needs to allocate multiple arrays.
 * ...
 * NOTE: For small data sets, the memory allocation can be expensive relative to the
 * number of elements the algorithm needs to touch
 */
