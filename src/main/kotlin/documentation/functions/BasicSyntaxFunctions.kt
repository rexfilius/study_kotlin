package documentation.functions

fun main() {
    println("Hello World")
    println("Sum of 3 and 5: ${sum(3, 5)}")
    println("Sum of 4 and 6: ${sum(4, 6)}")
    printSum(6,3)
    printSum2(4, 7)
}

// function having two Int parameters with Int return type:
fun sum(a: Int, b: Int): Int {
    return a + b
}

// function with an expression body and inferred return type
fun sum2(a: Int, b: Int) = a + b

// function returning no meaningful value
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

// Unit return type can be omitted
fun printSum2(a:Int, b:Int) {
    println("sum of $a and $b is ${a + b}")
}