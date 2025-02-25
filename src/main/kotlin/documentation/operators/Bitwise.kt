package documentation.operators

import newLine

fun main() {
    /**
     * Kotlin provides a set of BITWISE OPERATIONS on integer numbers. They operate on
     * the binary level directly with bits of the numbers' representation. Bitwise
     * operations are represented by functions that can be called in infix form.
     * They can be applied only to Int and Long.
     * Here is the complete list of bitwise operations:
     * - shl(bits): signed shift left
     * - shr(bits): signed shift right
     * - ushr(bits): unsigned shift right
     * - and(bits): bitwise and
     * - or(bits): bitwise or
     * - xor(bits): bitwise xor
     * - inv(): bitwise inversion
     */
    val xd = (1 shl 2) and 0x000FF000
    println("bitwise op: $xd")
    "" newLine ""
}