package generics

/**
 * - DECLARATION-SITE VARIANCE allows for more concise code, because you specify the
 * variance modifiers once, and clients of your class don’t have to think about them.
 * In Java, to create APIs that behave according to users’ expectations, the library
 * writer has to use wildcards all the time. Specifying the variance once on the
 * declaration makes the code much more concise and elegant.
 * - Kotlin supports USE-SITE VARIANCE too, allowing you to specify the variance for a
 * specific occurrence of a type parameter even when it can’t be declared as covariant
 * or contravariant in the class declaration.
 * - interfaces like MutableList, are not covariant or contravariant in a general case,
 * because they can both produce and consume values of types specified by their type
 * parameters. But it’s common for a variable of that type in a particular function to
 * be used in only one of those roles: either as a producer or as a consumer.
 * - This function copies elements from one collection to another. Even though both
 * collections have an invariant type, the source collection is only used for reading,
 * and the destination collection is only used for writing. In this situation,
 * the element types of the collections don’t need to match exactly. e.g. it’s perfectly
 * valid to copy a collection of strings into a collection that can contain any objects.
 */
fun <T> copyData(source: MutableList<T>, destination: MutableList<T>) {
    for (item in source) {
        destination.add(item)
    }
}

/**
 * - To make [copyData] function work with lists of different types, you can introduce
 * the second generic parameter.
 * - You declare two generic parameters representing the element types in the source and
 * destination lists. To be able to copy elements from one list to the other, the source
 * element type should be a subtype of elements in the destination list, like Int is a
 * subtype of Any.
 */
fun <T : R, R> copyData2(
    source: MutableList<T>,
    destination: MutableList<R>
) {
    for (item in source) {
        destination.add(item)
    }
}

/**
 * - Kotlin provides a more elegant way to write [copyData2]. When the implementation
 * of a function only calls methods that have the type parameter in the out
 * (or only in the 'in') position, you can take advantage of it and add variance
 * modifiers to the particular usages of the type parameter in the function definition.
 * - You can specify a variance modifier on any usage of a type parameter in a type
 * declaration: for a parameter type, local variable type, function return type etc.
 * What happens here is called type projection: we say that source isn’t a regular
 * MutableList, but a projected (restricted) one. You can only call/use methods that
 * return the generic type parameter in the 'out' position only. The compiler prohibits
 * calling methods where this type parameter is used as an argument (in the 'in' position)
 */
fun <T> copyData3(source: MutableList<out T>, destination: MutableList<T>) {
    for (item in source) destination.add(item)
}

/**
 * - In a similar way, you can use the 'in' modifier on a usage of a type parameter to
 * indicate that in this particular location the corresponding value acts as a consumer,
 * and the type parameter can be substituted with any of its supertypes.
 * - Use-site variance declarations in Kotlin correspond directly to Java bounded
 * wildcards.
 * - MutableList-out-T in Kotlin means the same as MutableList-?-extends-T in Java.
 * - The in-projected MutableList-in-T corresponds to Java’s MutableList-?-super-T.
 */
fun <T> copyData4(source: MutableList<T>, destination: MutableList<in T>) {
    for (item in source) {
        destination.add(item)
    }
}

fun main() {
    val ints = mutableListOf(1, 2, 3)
    val ints2 = mutableListOf<Int>()
    val anyItems = mutableListOf<Any>()
    val numItems = mutableListOf<Number>()

    copyData(ints, ints2)
    copyData2(ints, anyItems)
    copyData3(ints, anyItems)
    copyData4(ints, numItems)
    println(anyItems)    // [1, 2, 3]
    println(numItems)

    val list: MutableList<out Number> = mutableListOf(1, 2, 3, 4)
    // list.add(42)
    //Error: Out-projected type 'MutableList<out Number>' prohibits
    // the use of 'fun add(element: E): Boolean'

}