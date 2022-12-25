package otherConcepts.jvmInterop

/**
 * Inheritance from Java classes:
 * At most one Java class (and as many Java interfaces as you like) can be a supertype
 * for a class in Kotlin
 */

fun main() {

    /**
     * Accessing Static Members:
     * Static members of Java classes form "companion objects" for these classes.
     * You can't pass such a "companion object" around as a value but can access the
     * members explicitly. To access static members of a Java type that is mapped to a
     * Kotlin type, use the full qualified name of the Java type:
     * e.g. java.lang.Integer.bitCount(foo)
     */
    val code = 's'
    if (Character.isLetter(code)) {
        // do Something
    }

    /**
     * Kotlin supports SAM conversions for both Java and Kotlin interfaces. This support
     * for Java means that Kotlin function literals can be automatically converted into
     * implementations of Java interfaces with a single non-default method, as long as
     * the parameter types of the interface method match the parameter types
     * of the Kotlin function. SAM conversions only work for interfaces, not for abstract
     * classes, even if those also have just a single abstract method.
     */
    val run = Runnable { println("This runs in a runnable") }

}