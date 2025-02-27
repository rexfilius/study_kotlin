package documentation.dataStructures.arrays

import newLine

fun main() {

    /*
     * An array is a data structure that holds a fixed number of values of the same type or its subtypes.
     * The most common type of array in Kotlin is the object-type array, represented by the Array class.
     * ...
     * Collections have the following benefits compared to arrays:
     * (1) Collections can be read-only, which gives you more control and allows you to write
     * robust code that has a clear intent.
     * (2) It is easy to add or remove elements from collections. In comparison, arrays are fixed in size.
     * The only way to add or remove elements from an array is to create a new array each time,
     * which is very inefficient.
     * (3) You can use the equality operator (==) to check if collections are structurally equal.
     * You can't use this operator for arrays.
     */
    val names = arrayOf("John", 4, "Yu", "Kate", true, null, 'A')
    names.forEach { print("$it. ") }
    "" newLine ""

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