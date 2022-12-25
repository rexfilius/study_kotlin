package intro

/**
 * Certain functions can be 'upgraded' to 'operators', allowing their calls with the
 * corresponding operator symbol.
 * In the function below: the operator symbol for 'times()' is '*' so that you can call
 * the function using '2 * Bye'
 */
operator fun Int.times(str: String) = str.repeat(this)

/**
 * An operator allows easy range access on strings. The get() operator enables
 * bracket-access syntax
 */
operator fun String.get(range: IntRange) = substring(range)

fun main() {

    println( 2 * "Bye")

    val str = "Always forgive your enemies; nothing annoys them so much."
    println(str[0..14])
}