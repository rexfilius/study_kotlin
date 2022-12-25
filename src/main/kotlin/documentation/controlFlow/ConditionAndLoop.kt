package controlFlow

fun main() {

    /**
     *In Kotlin, if is an expression: it returns a value. Therefore, there is no
     * ternary operator (condition ? then : else) because
     * ordinary if works fine in this role
     */
    val b = 3 / 2
    val a = 1
    var max = a
    if (a < b) max = b

    // 'if' with else statement
    val maximum: Int
    if (a > b) {
        maximum = a
    } else {
        maximum = b
    }

    // 'if' as expression
    val mas = if (a > b) a else b

    // branches of 'if' branches can be blocks. in this case, the last expression
    // is the value of a block
    val m = if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }
}