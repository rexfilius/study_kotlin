package documentation.operators

import newLine

fun main() {
    /**
     * Kotlin supports the standard set of arithmetical operations over numbers:
     * -> + - * / % -> They are declared as members of appropriate classes.
     * You can also override these operators for custom classes.[Operator overloading]
     */
    println(1 + 2)
    println(2_500_000_000L - 1L)
    println(3.14 * 2.71)
    println(10.0 / 3)
    "" newLine ""

    /**
     * Division between integers numbers always returns an integer number. Any fractional
     * part is discarded. This is true for a division between any two integer types.
     * To return a floating-point type, explicitly convert one of the arguments to
     * a floating-point type.
     */
    val x = 5 / 2
    // println(typeSystem.getX == 2.5)  // ERROR!
    println("typeSystem.getX = 5/2, is typeSystem.getX = 2? ${x == 2}")

    val y = 5L / 2
    println("y = 5L/2, is y = 2L? ${y == 2L}")

    val z = 5 / 2.toDouble()
    println("z = 5/2.toDouble(), is z = 2.5? ${z == 2.5}")
    "" newLine ""
}