package documentation.typeSystem

fun main() {
    /*
    * NUMBERS:: UNSIGNED INTEGERS
    * Unsigned types support most of the operations of their signed counterparts.
    *
    * UByte -> 8 bits -> min_0 max_255
    * UShort -> 16 bits -> min_0 max_65,535
    * UInt -> 32 bits -> min_0 max_4,294,967,295(2^32 - 1)
    * ULong -> 64 bits -> min_0 max_18,446,744,073,709,551,615(2^64 - 1)
    *
    * The main use case of unsigned numbers is utilizing the full bit range of an integer to represent
    * positive values. e.g. to represent hexadecimal constants that do not fit in signed types
    * such as color in 32-bit "AARRGGBB" format:
    */
    val b: UByte = 1u  // UByte, expected type provided
    val s: UShort = 1u // UShort, expected type provided
    val l: ULong = 1u  // ULong, expected type provided

    val a1 = 42u // UInt: no expected type provided, constant fits in UInt
    val a2 = 0xFFFF_FFFF_FFFFu // ULong: no expected type provided, constant doesn't fit in UInt
    val a = 1UL // ULong, even though no expected type provided and the constant fits into UInt

    println("$b $s $l $a1 $a2 $a")

    val yellow = UColor(0xFFCC00CCu)
    println(yellow)
}

data class UColor(val representation: UInt)

