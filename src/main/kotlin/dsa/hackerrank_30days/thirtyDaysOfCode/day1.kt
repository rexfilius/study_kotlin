package thirtyDaysOfCode

/**
 * - TASK
 * To complete this challenge, you must save a line of input from stdin
 * to a variable, print Hello, World. on a single line, and finally print
 * the value of your variable on a second line.
 *
 * - INPUT FORMAT
 * A single line of text denoting inputString
 * (the variable whose contents must be printed).
 *
 * - OUTPUT FORMAT
 * Print Hello, World. on the first line, and the contents of inputString
 * on the second line.
 *
 * - SAMPLE INPUT
 * Welcome to 30 Days of Code!
 *
 * - SAMPLE OUTPUT
 * Hello, World.
 * Welcome to 30 Days of Code!
 */
fun main() {
    val inputString = readLine()!!

    println("Hello, World.")

    println(inputString)
}