package documentation.typeSystem

import newLine

fun main() {
    /*
     * NUMBERS:: INTEGER TYPES
     * Kotlin provides a set of built-in types that represent numbers. For integer
     * numbers, there are four types with different SIZES & VALUE RANGES: Byte, Short,
     * Int, Long.
     * ...
     * All variables initialized with integer values not exceeding the maximum value of
     * Int have the inferred type Int. If the initial value exceeds this value, then the
     * type is Long. To specify the Long value explicitly, append the suffix L
     * to the value.
     * ...
     * Byte -> 8 bits -> -128 to 127
     * Short -> 16 bits -> -32768 to 32767
     * Int -> 32 bits -> -2,147,483,648(-2^31) to 2,147,483,647(2^31 - 1)
     * Long -> 64 bits -> -9,223,372,036,854,775,808(-2^63) to 9,223,372,036,854,775,807(2^63 - 1)
     */
    val one = 1  // Int
    val threeBillion = 3000000000  // Long
    val oneLong = 1L  // Long
    val oneByte: Byte = 1

    println("$one $threeBillion $oneLong $oneByte")
    "" newLine ""
}