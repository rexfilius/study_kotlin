package generics

/**
 * - If you’re going to write a function that works with a list, and you want it to work
 * with any list (a generic one), not a list of elements of a specific type, you need to
 * write a generic function. A generic function has type parameters of its own. These
 * type parameters must be replaced with the specific type arguments on each function invocation.
 */
fun main() {

    /** CALLING A GENERIC FUNCTION */
    val letters = ('a'..'z').toList()
    println(letters)
    println(letters.slice<Char>(0..2))    // explicit type arguments
    println(letters.slice(10..13))

    println(listOf(1, 2, 3, 4).penultimate)

}

/** - Generic Extension properties: this returns the element before the last one in the list
 * - Regular (non-extension) properties can’t have type parameters. It’s not possible to
 * store multiple values of different types in a property of a class, and therefore
 * declaring a generic non-extension property does not make sense. If you try to do that,
 * the compiler reports an error
 */
val <T> List<T>.penultimate: T
    get() = this[size - 2]