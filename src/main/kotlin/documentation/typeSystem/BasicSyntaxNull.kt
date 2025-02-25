package documentation.typeSystem

// A reference must be explicitly marked as nullable when null value is possible.

fun main() {

}

// Return null if str does not hold an integer.
fun parseInt(str: String): Int? {
    if (str.contains('w')) return null
    return null // placeholder code
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // Using `typeSystem.getX * y` yields error because they may hold nulls.
    if (x != null && y != null) {
        // typeSystem.getX and y are automatically cast to non-nullable after null check
        println(x * y)
    } else {
        println("'$arg1' or '$arg2' is not a number")
    }
}

fun printProduct2(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if (x == null) {
        println("Wrong number format in arg1: '$arg1'")
        return
    }
    if (y == null) {
        println("Wrong number format in arg2: '$arg2'")
        return
    }

    // typeSystem.getX and y are automatically cast to non-nullable after null check
    println(x * y)
}