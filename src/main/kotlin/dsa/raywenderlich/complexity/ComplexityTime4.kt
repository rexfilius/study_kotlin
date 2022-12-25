package raywenderlich.complexity

/**
 * - sum of numbers from 1 to 10
 * - If you try the function above with n = 10,000; the code loops 10,000 times and
 * returns 50005000. It's O(n) and will take a moment to run as it counts through
 * the loop and prints results. This can be better
 */
fun sumFromOneTo(n: Int): Int {
    var result = 0
    for (i in 1..n) {
        result += i
    }
    return result
}

/**
 * The time complexity of this version is also O(n) since it essentially performs
 * the same logic. It continuously adds each element to the sum and returns the
 * total sum
 */
fun sumFromOneToII(n: Int): Int {
    return (1..n).reduce { sum, element -> sum + element }
}

/**
 * - This version of the function uses a formula by Fredrick Gauss. The sum of a
 * series of numbers starting from 1 up to n can be computed using simple arithmetic.
 * - This version of the algorithm above is O(1). A constant time algorithm is always
 * preferred over a linear or logarithmic time since the time it takes to run will
 * not change regardless of how large n gets.
 */
fun sumFromOneToIII(n: Int): Int {
    return n * (n + 1) / 2
}

fun main() {
    println(sumFromOneTo(10))

    println(sumFromOneToII(10))

    println(sumFromOneToIII(10))
}