package documentation.dataStructures.arrays

import newLine

fun main() {

    /**
     * Arrays in Kotlin are represented by the Array class. It has get and set functions
     * that turn into [] by operator overloading conventions, and the size property,
     * along with other useful member functions
     * - Arrays in Kotlin are invariant. This means that Kotlin does not let us assign an
     * Array<String> to an Array<Any>, which prevents a possible runtime failure
     * (but you can use Array<out Any>, see Type Projections ).
     */
    val names = arrayOf("John", 4, "Yu", "Kate", true, null, 'A')
    names.forEach { print("$it. ") }
    "" newLine ""
    for (i in names) print("$i. ")
    "" newLine "\n"

    val nameNull = arrayOfNulls<Int>(4)
    nameNull.forEach { print("$it. ") }
    nameNull[0] = 1
    nameNull.forEach { print("[$it]") }
    "" newLine "\n"

    val asc = Array(5) { i -> (i * i).toString() }
    asc.forEach { print("$it. ") }
    "" newLine "\n"

    /**
     * Kotlin also has classes that represent arrays of primitive types without boxing
     * overhead: ByteArray, ShortArray, IntArray, LongArray, CharArray, BooleanArray.
     * These classes have no inheritance relation to the Array class, but they have the
     * same set of methods and properties. Each of them also has
     * a corresponding factory function
     */
    val x: IntArray = intArrayOf(1, 2, 3)
    x.forEach { print("$it. ") }
    "" newLine ""

    var integerArray = IntArray(5)
    integerArray.forEach { print("$it. ") }
    "" newLine ""

    integerArray = IntArray(5) { 42 }
    integerArray.forEach { print("$it. ") }
    "" newLine ""

    integerArray = IntArray(5) { it * 1 }
    integerArray.forEach { print("$it. ") }
}