package documentation.otherConcepts

import kotlin.reflect.KClass

/**
 * Annotations can have constructors that take parameters. Allowed parameter types are:
 * Types that correspond to Java primitive types(Int, Long etc.); Strings; Classes;
 * Enums; Other annotations; Arrays of the types aforementioned.
 * ...
 * Annotation parameters cannot have nullable types, because the JVM does not support
 * storing null as a value of an annotation attribute.
 */

// If an annotation is used as a parameter of another annotation,
// its name is not prefixed with the @ character.
annotation class ReplaceWith(val expression: String)
annotation class Deprecated(
        val message: String,
        val replaceWith: ReplaceWith = ReplaceWith("")
)

@Deprecated("This function is deprecated, use === instead",
        ReplaceWith("this === other")
)
fun printG() = println("G")

/**
 * If you need to specify a class as an argument of an annotation,
 * use a Kotlin class (KClass). The Kotlin compiler will automatically convert it to a
 * Java class, so that the Java code can access the annotations and arguments normally
 */
annotation class Ann(val arg1: KClass<*>, val arg2: KClass<out Any>)

@Ann(String::class, Int::class)
fun printS() = println("S")

// NOTE: Annotation can also be used on lambdas