package thirtyDaysOfCode

fun main() {
    print("Enter a non-negative integer: ")
    val number = readln().toInt()
    println("Factorial of $number = ${factorial(number)}")
}

fun factorial(n: Int): Long {
    return if (n == 0) 1
    else n * factorial(n - 1)
}