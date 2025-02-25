package documentation.functions

/**
 * REIFIED TYPE PARAMETERS
 * Sometimes you need to access a type passed as a parameter. You qualify the type
 * parameter with the reified modifier to make it accessible inside the function,
 * almost as if it were a normal class. Normal functions (not marked as inline) cannot
 * have reified parameters. A type that does not have a run-time representation
 * (for example, a non-reified type parameter or a fictitious type like Nothing)
 * cannot be used as an argument for a reified type parameter.
 */
inline fun <reified T> membersOf() = T::class.members

fun main() {
    println(membersOf<StringBuilder>().joinToString("\n"))
}

/**
 * The inline modifier can be used on accessors of properties that don't have a backing
 * field. You can annotate individual property accessors. At the call site,
 * inline accessors are inlined as regular inline functions.
 */
val x: String
    inline get() = "Something"

var y: Int
    get() = 3
    inline set(value) = println(value)
