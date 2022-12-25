package raywenderlich.complexity

fun main() {

    // QUADRATIC TIME
    multiplicationBoard(2)

}

/**
 * - QUADRATIC TIME - O(n^2)
 * Commonly referred to as 'n squared', this time complexity refers to an algorithm
 * that takes time proportional to the square of the input size
 * - If the input is 10, it will print the full multiplication board of 10 x 10.
 * That's 100 print statements. If you increase the input size by one(11 x 11),
 * it will result in 121 statements.
 * - Unlike linear time complexity, the n squared algorithm can quickly run out of
 * control as the data increases. n squared algorithm doesn't perform well at scale
 */
fun multiplicationBoard(size: Int) {
    for (number in 1..size) {
        print(" | ")
        for (otherNumber in 1..size) {
            print("$number x $otherNumber = ${number * otherNumber} | ")
        }
        println()
    }
}

/**
 * NOTE: No matter how inefficiently a Linear Time O(n) algorithm is written, for a
 * sufficiently large n, the linear time algorithm will always execute faster than
 * a super optimized quadratic algorithm.
 * ...
 * For instance, optimizing for absolute efficiency can be crucial. Companies put
 * millions of dollars of R&D into reducing the slope of those constants that Big O
 * notation ignores
 * e.g. a GPU optimized version of an algorithm might run 100× faster than the naive
 * CPU version while remaining O(n)
 */
