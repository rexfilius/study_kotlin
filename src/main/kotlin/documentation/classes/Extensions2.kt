package classes

/**
 * Note that extensions can be defined with a nullable receiver type. Such extensions
 * can be called on an object variable even if its value is null, and can check
 * for this == null inside the body.
 */
fun Any?.toString(): String {
    if (this == null) return "null"
    // after the null check, 'this' is autocast to a non-null type, so the
    // toString() below resolves to the member function of the Any class
    return toString()
}

/**
 * Kotlin also supports extension properties. Since extensions do not actually insert
 * members into classes, there's no efficient way for an extension property to have a
 * backing field. This is why initializers are not allowed for extension properties.
 * Their behavior can only be defined by explicitly providing getters/setters.
 */
val <T> List<T>.lastIndex: Int
    get() = size - 1

/**
 * If a class has a companion object defined, you can also define extension functions
 * and properties for the companion object. Just like regular members of the companion
 * object, they can be called using only the class name as the qualifier
 */
class MyClass {
    companion object Companion {/**/ }
}

fun MyClass.Companion.printCompanion() = println("companion")

fun main() {
    MyClass.printCompanion()
}

