package documentation.classes

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

/**
 * The most basic usage of enum classes is implementing type-safe enums. Each enum constant
 * is an object. And since they are an instance of a class, they can be initialized
 */
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

/**
 * Enum constants can also declare their own anonymous classes with their corresponding
 * methods, as well as overriding base methods...If the enum class defines any members,
 * separate the enum constant definitions from the member definitions with a semicolon
 */
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },
    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

/**
 * An enum class can implement an interface (but not derive from a class), providing
 * either a single interface members implementation for all of the entries, or separate
 * ones for each entry within its anonymous class. This is done by adding the
 * interfaces to the enum class declaration.
 */
enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(t: Int, u: Int): Int = apply(t, u)
}

/**
 * Enum classes in Kotlin have synthetic methods foe listing the defined enum constants by
 * its name. Every enum constant has properties to obtain its name and position in the
 * enum class declaration - properties: 'name' & 'ordinal'
 */
enum class RGB { RED, GREEN, BLUE }

inline fun <reified T : Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
    print(enumValues<T>().joinToString { "...${it.ordinal}" })
}

fun main() {
    println(IntArithmetics.PLUS.apply(4, 7))
    println(IntArithmetics.TIMES.apply(4, 7))
    println()

    printAllValues<RGB>()
}
