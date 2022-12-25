package typeSystem

import newLine

fun main() {
    /**
     * Characters are represented by the type Char. Character literals go in single
     * quotes 'A'. Escape sequences are supported: \t \b \n \r \' \" \\ \$.
     * To encode any other character, use the Unicode escape sequence syntax '\uFF00'
     * On JVM: Like numbers, characters are boxed when a nullable reference is needed.
     * Identity is not preserved by the boxing operation.
     */
    val aChar = 'a'
    println(aChar)
    println('\uFF00')
    println(decimalDigitValue('3'))
    "" newLine ""
}


/**
 * If a value of a character variable is a digit,
 * you can explicitly convert it to an Int number
 */
fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9') {
        throw IllegalArgumentException("Out of range")
    }
    return c.toInt() - '0'.toInt()
}