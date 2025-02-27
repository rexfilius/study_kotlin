package documentation.typeSystem

import newLine

fun main() {

    /*
     * NUMBERS:: EXPLICIT CONVERSIONS
     * Due to different representations, smaller types are not subtypes of bigger ones.
     * As a consequence, smaller types are NOT implicitly converted to bigger types.
     * This means that assigning a value of type Byte to an Int variable requires
     * an explicit conversion.
     * ...
     * All number types support conversions to other types: toByte(): Byte ->
     * toShort(): Short -> toInt(): Int -> toLong(): Long -> toFloat(): Float
     * toDouble(): Double -> toChar(): Char
     * ...
     * Kotlin doesn't support implicit conversions because they can lead to unexpected behavior.
     */
    val bt: Byte = 1 // OK, literals are checked statically
    // val i: Int = bt // ERROR - type mismatch
    val i1: Int = bt.toInt()
    println("$i1 $bt")
    "" newLine ""

    /*
     * NUMBERS:: OPERATION ON NUMBERS
     * Kotlin supports the standard set of arithmetical operations over numbers: +, -, *, /, %.
     * You can override these operators in custom number classes. (see Operator overloading)
     *
     * Division between integer numbers always returns an integer number.
     * Any fractional part is discarded. To return a division result with the fractional part,
     * explicitly convert one of the arguments to a floating-point type:
     */
    println(1 + 2)
    println(2_500_000_000L - 1L)
    println(3.14 * 2.71)
    println(10.0 / 3)
    println(5 / 2) // 2 instead of 2.5
    println(5 / 2.toDouble()) // 2.5

}