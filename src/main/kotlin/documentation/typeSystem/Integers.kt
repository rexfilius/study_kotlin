package documentation.typeSystem

import newLine

fun main() {
    /**
     * NUMBERS:: INTEGER TYPES
     * Kotlin provides a set of built-in types that represent numbers. For integer
     * numbers, there are four types with different SIZES & VALUE RANGES: Byte, Short,
     * Int, Long.
     * ...
     * All variables initialized with integer values not exceeding the maximum value of
     * Int have the inferred type Int. If the initial value exceeds this value, then the
     * type is Long. To specify the Long value explicitly, append the suffix L
     * to the value.
     */
    val one = 1  // Int
    val threeBillion = 3000000000  // Long
    val oneLong = 1L  // Long
    val oneByte: Byte = 1
    println("$one $threeBillion $oneLong $oneByte")
    "" newLine ""
}