package documentation.typeSystem

import newLine

fun main() {
    /*NUMBERS :: FLOATING POINT
    * For real numbers, Kotlin provides floating-point types Float and Double that adhere to
    * the IEEE 754 standard. Float reflects the IEEE 754 single precision,
    * while Double reflects double precision.
    *
    * Float -> 32 bits -> 24 significant bits -> 8 exp bits -> 6-7 decimal digits
    * Double -> 64 bits -> 53 significant bits -> 11 exp bits -> 15-16 decimal digits
    */
    val inferredDouble = 3.14
    val eFloat = 2.7182817f
    val anotherDouble = 2.33e10

    println("$inferredDouble $eFloat $anotherDouble")
    "" newLine ""

    /*
    * Unlike in some other languages, there are no implicit widening conversions for numbers in Kotlin.
    * e.g. a function with a Double parameter can be called only on Double values, but not Float,
    * Int, or other numeric values
    */
    printADoubleNum(2.34)

    /*Decimals, Hexadecimals, Binaries are supported in Kotlin, no Octal*/
}

fun printADoubleNum(x: Double) {
    print("$x is a double")
}