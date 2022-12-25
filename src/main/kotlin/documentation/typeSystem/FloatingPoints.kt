package typeSystem

import newLine

fun main() {
    /**
     * NUMBERS:: FLOATING-POINT TYPES
     * For real numbers, Kotlin provides floating-point types Float and Double. According
     * to the IEEE 754 standard, floating point types differ by their decimal place, i.e,
     * how many decimal digits they can store. Float reflects the IEEE 754 single
     * precision, while Double provides double precision.
     * ...
     * You can initialize Double and Float variables with numbers having a fractional
     * part. It's separated from the integer part by a period (.) For variables
     * initialized with fractional numbers, the compiler infers the Double type.
     * To explicitly specify the Float type for a value, add the suffix f or F. If such a
     * value contains more than 6-7 decimal digits, it will be rounded.
     */
    val pi = 3.14  // Double
    val oneDouble = 1.0  // Double
    val e = 2.7182818284  // Double
    val eFloat = 2.7182818284f  // Float with > 6-7 decimal digits, will be rounded up
    println("$pi $oneDouble $e $eFloat")

    val i = 1
    val d = 1.0
    val f = 1.0f
    printDouble(d)
    //printDouble(i)  // Error: Type mismatch
    //printDouble(f)  // Error: Type mismatch
    println("$i $f")
    "" newLine ""
}

/**
 * There are no implicit widening conversions for numbers in Kotlin.
 * A function with a Double parameter can be called only on Double values.
 * To convert numeric values to different types, use Explicit Conversions.
 */
fun printDouble(d: Double) = println(d)