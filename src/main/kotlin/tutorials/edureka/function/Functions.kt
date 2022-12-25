package function

fun main() {
    println("the sum is ${sum(3,4)}")
    println("sub = ${getData(20, 40)}")
    println()

    val multiply = {num1: Int, num2: Int -> num1 * num2}
    println("15 times 6 = ${multiply(15,6)}")
    println()

    println("5! = ${findFactorial(5)}")
}

fun sum(a: Int, b: Int) : Int {
    return a + b
}

fun getData(vararg result: Int): Int {
    var sub = 0
    result.forEach { n -> sub += n }
    return sub
}

fun findFactorial(x: Int): Int {
    tailrec fun factorial(a: Int, b: Int): Int {
        if (a == 0)
            return b
        else
            return factorial(a-1, a*b)
    }
    return factorial(x,1)
}
