package generics

/**
 * GENERIC FUNCTIONS
 * - Not only classes can have type parameters. Functions can, too. Type parameters are
 * placed before the name of the function
 * - To call a generic function, specify the type arguments at the call site after
 * the name of the function
 * - Type arguments can be omitted if they can be inferred from the context
 */
fun <T> singletonLists(item: T): List<T> {
    return listOf()
}

fun <T> T.basicsToString(): String {    // extension function
    return ""
}

val someList = singletonLists<Int>(1)  // you can omit the type if it can be inferred


/**
 * GENERIC CONSTRAINTS
 * - The most common type of constraint is an upper bound that corresponds to
 * Java's extends keyword
 * - The type specified after a colon is the upper bound: only a subtype of
 * Comparable<T> can be substituted for T
 */
fun <T : Comparable<T>> sortX(list: List<T>) {}

/**
 * - The default upper bound (if none specified) is Any?. Only one upper bound can be
 * specified inside the angle brackets. If the same type parameter needs more than one
 * upper bound, you need a separate 'where' clause
 * - The passed type must satisfy all conditions of the where clause simultaneously.
 * In the function below, the T type must implement both CharSequence and Comparable.
 */
fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
        where T : CharSequence,
              T : Comparable<T> {
    return list.filter { it > threshold }.map { it.toString() }
}

fun main() {

    sortX(listOf(1, 2, 3))
    // OK. Int is a subtype of Comparable<Int>

    // sortX(listOf(HashMap<Int, String>()))
    // Error: HashMap<Int, String> is not a subtype of Comparable<HashMap<Int, String>>

}