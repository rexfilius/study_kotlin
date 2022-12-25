package generics

/**
 * - Reified type parameters allow you to refer at runtime to the specific types used
 * as type arguments in an inline function call. (For normal classes or functions,
 * this isn’t possible, because type arguments are erased at runtime.)
 * - Declaration-site variance lets you specify whether a generic type with a type
 * argument is a subtype or a supertype of another generic type with the same base type
 * and a different type argument. e.g. it regulates whether it’s possible to
 * pass arguments of type List-Int to functions expecting List-Any.
 * - Use-site variance achieves the same goal for a specific use of a generic type and
 * therefore accomplishes the same task as Java’s wildcards.
 * - Generics allow you to define types that have type parameters. When an instance of
 * such a type is created, type parameters are substituted with specific types called
 * type arguments.
 * - For example, if you have a variable of type List, it’s useful to know what kind of
 * things are stored in that list. The type parameter lets you specify exactly that
 * instead of “This variable holds a list,” you can say something like
 * “This variable holds a list of strings.” Kotlin’s syntax for saying
 * “a list of strings” looks the same as in Java: List-String.
 * - NOTE_1:: Unlike Java, Kotlin always requires type arguments to be either specified explicitly
 * or inferred by the compiler. Because generics were added to Java only in version 1.5,
 * it had to maintain compatibility with code written for older versions, so it allows
 * you to use a generic type without type arguments — a so-called raw type.
 * - NOTE_2:: For example, in Java, you can declare a variable of type List without
 * specifying what kind of things it contains. Because Kotlin has had generics from the
 * beginning, it does not support raw types, and the type arguments must always be defined.
 */
fun main() {

    /** Type arguments can often be inferred by the Kotlin compiler */
    val authors = listOf("Jake", "Mike")

    /**
     * - If you need to create an empty list, there’s nothing from which to infer the
     * type argument, so you need to specify it explicitly. In the case of creating a
     * list, you have a choice between specifying the type as part of the variable
     * declaration and specifying a type argument for the function that creates a list
     */
    val readers: MutableList<String> = mutableListOf()
    val anotherReaders = mutableListOf<String>()

}
