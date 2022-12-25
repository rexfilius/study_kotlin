package raywenderlich.complexity

/**
 * - The time complexity of an algorithm isn't the only performance metric against
 * which algorithms are ranked. Another important metric is its SPACE COMPLEXITY;
 * a measure of the amount of memory it uses
 * - The function below creates a sorted copy of the list and prints it. To calculate
 * the space complexity, you analyze the amount of memory the function allocates.
 * Since numbers.sorted() produces a new list with the same size of numbers, the space
 * complexity of [printSortedI] is O(n). While this function is simple and elegant, there
 * may be some situations in which you want to allocate as little memory as possible
 */
fun printSortedI(numbers: List<Int>) {
    val sorted = numbers.sorted()
    for (element in sorted) println(element)
}

/**
 * - You can rewrite the former function as shown below. The overall goal is to
 * iterate through the array multiple times, printing the next smallest value for
 * each iteration
 * - The algorithm below only allocates memory for a few variables. Since the amount
 * of memory allocated is constant and doesn't depend on the size of the list,
 * the space complexity is O(1)
 */
fun printSortedII(numbers: List<Int>) {

    // check for the case if the list is empty - nothing to print
    if (numbers.isEmpty()) return

    // currentCount keeps track of the number of print statements made.
    // minValue stores the last printed value.
    var currentCount = 0
    var minValue = Int.MIN_VALUE

    // print all values matching the minValue and update currentCount according
    // to the number of print statements made
    for (value in numbers) {
        if (value == minValue) {
            println(value)
            currentCount += 1
        }
    }

    while (currentCount < numbers.size) {

        // find the lowest value bigger than minValue
        // and store it in currentValue
        var currentValue = numbers.maxOrNull()!!
        for (value in numbers) {
            if (value in (minValue + 1) until currentValue) {
                currentValue = value
            }
        }

        // print all values of currentValue inside the array
        // while updating currentCount
        for (value in numbers) {
            if (value == currentValue) {
                println(value)
                currentCount += 1
            }
        }

        // minValue is set to currentValue, so the next iteration will try to find
        // the next minimum value
        minValue = currentValue
    } // end of While-loop
}

fun main() {
    val sortI = printSortedI(listOf(1, 4, 3, 5, 7))
    println(sortI)

    val sortII = printSortedII(listOf(1, 4, 3, 5, 7))
    println(sortII)
}