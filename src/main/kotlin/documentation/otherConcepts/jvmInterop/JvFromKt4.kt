package otherConcepts.jvmInterop

/**
 * Arrays in Kotlin are invariant(never-changing), unlike Java. This means that Kotlin
 * won't let you assign an Array<String> to an Array<Any>, which prevents a possible
 * runtime failure. Passing an array of a subclass as an array of superclass to a Kotlin
 * method is also prohibited, but for Java methods this is allowed through platform
 * types of the form Array<(out) String>!
 * ...
 * Arrays are used with primitive data types on the Java platform to avoid the cost of
 * boxing/unboxing operations. As Kotlin hides those implementation details, a workaround
 * is required to interface with Java code. There are specialized classes for every type
 * of primitive array (IntArray, DoubleArray, CharArray etc.) to handle this case.
 * They are not related to the Array class and are compiled down to Java's primitive
 * arrays for maximum performance.
 */
fun main() {

    // passing an array of Java primitive values in Kotlin
    val javaObj = JavaArrayExample()
    val array = intArrayOf(0, 1, 2, 3)
    javaObj.removeIndices(array)

    // when compiling to the JVM byte code, the compiler optimizes access to arrays so
    // that there's no overhead introduced
    val array2 = arrayOf(1, 2, 3, 4)
    array2[1] = array2[1] * 2    // no actual calls to get() & set() generated
    for (x in array2) {    // no iterator created
        print("$x..")
    }
    println()

    // even when you navigate an index, it doesn't introduce any overhead
    for (i in array2.indices) {
        array2[i] += 2
        print("$i. ")
    }
    println()

    // in-checks have no overhead either
    /* if (i in array.indices) { // same as (i >= 0 && i < array.size)
           print(array[i])
       }
    */

    // calling a java method with vararg parameter
    val j = JavaArrayExample()
    val arr = intArrayOf(0, 1, 2, 3)
    j.removeIndicesVarArg(*arr)
    // it's currently not possible to pass null to a method declared a varargs

}
