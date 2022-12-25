package typeSystem

import newLine

fun main() {
    /**
     * LITERAL CONSTANTS:: the examples below are the kinds of literal constants for
     * integral values. You can use underscores to make number constants more readable
     */
    val decimals = 123
    val longs = 123L
    val hexadecimal = 0x0F
    val binaries = 0b00001011
    val doubles = 123.5 + 123.5e10
    val floats = 123.5f
    println("$decimals $longs $hexadecimal $binaries $doubles $floats")

    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010
    println("$oneMillion $creditCardNumber $socialSecurityNumber $hexBytes $bytes")
    "" newLine ""
}