package documentation.generics

/**
 * USE-SITE VARIANCE: TYPE PROJECTIONS
 * - It is very convenient to declare a type parameter T as 'out' and avoid trouble with
 * subtyping on the use site, but some classes can't actually be restricted to only
 * return T's! A good example of this is Array class.
 * - This class cannot be either co- or contravariant in T.
 * And this imposes certain inflexibility.
 * - In the [copy] function below. This is type projection, that means that from is not
 * simply an array, but a restricted (projected) one. You can only call those methods
 * that return the type parameter T, in this case it means that you can only call get().
 * - This is Kotlin's approach to use-site variance, and corresponds to Java's
 * Array<? extends Object>, but in a slightly simpler way.
 */
fun copy(from: Array<out Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}

/**
 * - You can project a type with 'in' as well
 * - Array<in String> corresponds to Java's Array<? super String>. This means that you
 * can pass an array of CharSequence or an array of Object to the fill() function.
 * - For USE-SITE VARIANCE/TYPE PROJECTION ->
 * - out T ... can take a subtype of T .. (Java: <? extends Object>)
 * - in T ... can take a supertype of T .. (Java: <? super T>)
 */
fun fill(dest: Array<in String>, value: String) {}

fun main() {
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }

    copy(ints, any)
    // Error: type is Array<Int> but Array<Any> was expected (without out modifier)

    val char: Array<CharSequence> = arrayOf("Ada", "Bee")
    val word = "Check"

    fill(char, word)    // CharSequence is a super type of String

}




