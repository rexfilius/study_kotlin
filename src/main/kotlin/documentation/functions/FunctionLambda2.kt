package functions

/**
 * FUNCTION TYPES
 * Kotlin uses a family of function types like (Int) -> String for declarations that deal
 * with functions: val onClick: () -> Unit = .... These types have a special notation that
 * corresponds to the signatures of the functions - their parameters and return values:
 * 1. All function types have a parenthesized parameter types list and a return type:
 *    (A, B) -> C denotes a type that represents functions taking two arguments of types
 *    A and B and returning a value of type C. The parameter types list may be empty,
 *    as in () -> A. The Unit return type cannot be omitted.
 * 2. Function types can optionally have an additional receiver type, which is specified
 *    before a dot in the notation: the type A.(B) -> C represents functions that can be
 *    called on a receiver object of A with a parameter of B and return a value of C.
 *    Function literals with receiver are often used along with these types.
 * 3. Suspending functions belong to function types of a special kind, which have a
 *    suspend modifier in the notation, such as suspend () -> Unit or suspend A.(B) -> C
 * ... you can also give a function type an alternative name using a 'typealias'
 */
val aNothing = ""

/**
 * INSTANTIATING A FUNCTION TYPE
 * There are several ways to obtain an instance of a function type:
 * 1. Using a code block within a function literal, in one of the forms:
 *    : a lambda expression: { a, b -> a + b },
 *    : an anonymous function: fun(s: String): Int { return s.toIntOrNull() ?: 0 }
 * Function literals with receiver can be used as values of function types with receiver.
 * 2. Using a callable reference to an existing declaration:
 *    : a top-level, local, member, or extension function: ::isOdd, String::toInt,
 *    : a top-level, member, or extension property: List<Int>::size,
 *    : a constructor: ::Regex
 * These include bound callable references that point to a member of a particular
 * instance: foo::toString.
 * 3. Using instances of a custom class that implements a function type as an interface
 */
class IntTransformer : (Int) -> Int {
    override fun invoke(p1: Int): Int {
        return p1 * 2  // placeholder code
    }
}

val intFunction: (Int) -> Int = IntTransformer()

/**
 * Non-literal values of function types with and without receiver are interchangeable,
 * so that the receiver can stand in for the first parameter, and vice versa.
 * For instance, a value of type (A, B) -> C can be passed or assigned
 * where a A.(B) -> C is expected and the other way around:
 */
val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }
val twoParameters: (String, Int) -> String = repeatFun
fun runTransformation(f: (String, Int) -> String): String = f("hello", 3)
val res = runTransformation(repeatFun)

fun main() {
    println(res)
}