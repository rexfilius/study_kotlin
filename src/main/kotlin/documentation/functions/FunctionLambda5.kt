package functions

/**
 * One thing missing from some lambda expression syntax is the ability to specify the
 * return type of the function. In most cases, this is unnecessary because the return type
 * can be inferred automatically. However, if you do need to specify it explicitly, you
 * can use an alternative syntax: an anonymous function
 * ...
 * An anonymous function looks very much like a regular function declaration, except that
 * its name is omitted. Its body can be either an expression or a block
 */

/*
fun(typeSystem.getX: Int, y: Int): Int = typeSystem.getX + y

fun(name: String, age: Int) {
    println("My name is $name and I am $age years old")
}
*/

/**
 * One other difference between lambda expressions and anonymous functions is the behavior
 * of non-local returns. A return statement without a label always returns from the
 * function declared with the fun keyword. This means that a return inside a lambda
 * expression will return from the enclosing function, whereas a return inside an
 * anonymous function will return from the anonymous function itself
 */

fun main() {

    /**
     * A lambda expression or anonymous function (as well as a local function and an object
     * expression) can access its closure, which includes the variables declared in the
     * outer scope. The variables captured in the closure can be modified in the lambda
     */
    val integers = listOf(1, 5, 7, 4, 9, 14, 17, 31)
    var sum = 0
    integers.filter { it % 2 == 0 }.forEach {
        sum += it
    }
    println("sum = $sum")

}
