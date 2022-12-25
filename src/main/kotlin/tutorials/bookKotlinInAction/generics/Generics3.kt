package generics

/**
 * - Type parameter constraints let you restrict the types that can be used as type
 * arguments for a class or function. e.g. consider a function that calculates the sum
 * of elements in a list. It can be used on a List-Int or a List-Double, but not,
 * for e.g. a List-String. To express this, you can define a type parameter constraint
 * that specifies that the type parameter of sum must be a number.
 * - When you specify a type as an upper bound constraint for a type parameter of a
 * generic type, the corresponding type arguments in specific instantiations of the
 * generic type must be either the specified type or its subtypes
 * - Once you’ve specified a bound for a type parameter T, you can use values of type T
 * as values of its upper bound. e.g, you can invoke methods defined in the class
 * used as the bound.
 * - In Java, you use the keyword extends to express the same concept
 * - 'T extends Number' T sum(List-T list)
 */
fun <T : Number> List<T>.sum(): T {
    return this.first()
}

fun <T : Number> oneHalf(value: T): Double = value.toDouble() / 2.0

fun <T : Comparable<T>> max(first: T, second: T): T =
    if (first > second) first else second
// SAME AS: if (first.compareTo(second) > 0) first else second

/**
 * - In the rare case when you need to specify multiple constraints on a type parameter,
 * you use a slightly different syntax. e.g. the following listing is a generic way to
 * ensure that the given CharSequence has a period at the end. It works with both the
 * standard StringBuilder class and the java.nio.CharBuffer class.
 * - In this case, you specify that the type used as a type argument must implement
 * both the CharSequence and Appendable interfaces. This means both the operations
 * accessing the data (endsWith) as well as the operation modifying it (append) can be
 * used with values of that type.
 */
fun <T> ensureTrailingPeriod(seq: T) where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) seq.append('.')
}

fun main() {

    println(oneHalf(3))

    println(max("Kotlin", "Java"))

    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld)
}