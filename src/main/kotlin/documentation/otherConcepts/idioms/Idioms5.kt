package documentation.otherConcepts.idioms

fun main() {

    // try-catch expression
    val result = try {
        1 / 0
    } catch (e: ArithmeticException) {
        println("Illegal arithmetic")
    }

}

// Return on when statement
fun transform(color: String): Int {
    return when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }
}

// Single-expression functions
fun theAnswer() = 42
// equal to
fun theAnswer2(): Int {
    return 42
}
// can be combined with other idioms
fun transform2(color: String): Int = when (color) {
    "Red" -> 0
    "Green" -> 1
    "Blue" -> 2
    else -> throw IllegalArgumentException("Invalid color param value")
}

// if expression
// can also be a when expression - with more than 2 conditions
fun foo(param: Int) {
    val result = if (param == 1) {
        "one"
    } else {
        "others"
    }
}

// Builder-style usage of methods that return Unit
fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}