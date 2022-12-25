package operators

/**
 * Kotlin allows us to provide implementations for a predefined set of operators on our
 * types. These operators have fixed symbolic representation (like + or *) and fixed
 * precedence. To implement an operator, provide a member function or an extension
 * function with a fixed name, for the corresponding type, that means a left-hand side
 * type for binary operations and argument type for unary ones. Functions that overload
 * operators need to be marked with the operator modifier
 */
data class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus() = Point(-x, -y)

fun main() {
    val point = Point(10, 20)
    println(-point)

    val cn = Counter(3)
    val c = cn.plus(7)
    println(c)
}

data class Counter(val dayIndex: Int) {
    operator fun plus(increment: Int): Counter {
        return Counter(dayIndex + increment)
    }
}