package typeSystem

import newLine

fun main() {
    /**
     * NUMBER REPRESENTATION ON THE JVM
     * On the JVM platform, numbers are stored as primitive types: int, double, etc.
     * Exceptions are cases when you create a nullable number reference such as Int? or
     * use generics. In these cases numbers are boxed in Java classes Integer, Double etc.
     */
    val a = 100
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    val b = 10000
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b

    println("boxedA === anotherBoxedA: ${boxedA === anotherBoxedA}")  // true
    println("boxedB === anotherBoxedB: ${boxedB === anotherBoxedB}")  // false
    "" newLine ""

    /**
     * EXPLICIT CONVERSIONS
     * Due to different representations, smaller types are not subtypes of bigger ones.
     * As a consequence, smaller types are NOT implicitly converted to bigger types.
     * This means that assigning a value of type Byte to an Int variable requires
     * an explicit conversion.
     * ...
     * All number types support conversions to other types: toByte(): Byte ->
     * toShort(): Short -> toInt(): Int -> toLong(): Long -> toFloat(): Float
     * toDouble(): Double -> toChar(): Char
     * ...
     * - Hypothetical code, does not actually compile:
     * - val a: Int? = 1 // A boxed Int (java.lang.Integer)
     * - val b: Long? = a // implicit conversion yields a boxed Long (java.lang.Long)
     * - print(b == a) // Surprise! This prints "false" as Long's equals() checks whether the other is Long as well
     */
    val bt: Byte = 1 // OK, literals are checked statically
    // val i: Int = b // ERROR
    val i1: Int = bt.toInt()

    /**
     * In many cases, there is no need in explicit conversions because the type is
     * inferred from the context, and arithmetical operations are overloaded
     * for appropriate conversions
     */
    val l = 1L + 3 // Long + Int => Long
}