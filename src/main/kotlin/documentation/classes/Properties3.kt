package documentation.classes

import AnObject

/**
 * If the value of a read-only property is known at the compile time,
 * mark it as a compile time constant using the 'const' modifier.
 * Such properties need to fulfil the following requirements:
 * 1. Top-level, or member of an object declaration or a companion object.
 * 2. Initialized with a value of type String or a primitive type
 * 3. No custom getter
 * Such properties can be used in annotations
 */
const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"

@Deprecated(SUBSYSTEM_DEPRECATED)
fun fooD() {/**/
}

// Late-initialized properties and variables
class MyTest {
    lateinit var anObject: AnObject

    /**
     * 'lateinit' can be used on var properties declared inside the body of a class
     * (not in the primary constructor, and only when the property does not have
     * a custom getter or setter) as well as for top-level properties and
     * local variables. The type of the property or variable must be non-null,
     * and it must not be a primitive type. Accessing a lateinit property before it
     * has been initialized throws a special exception that clearly identifies
     * the property being accessed and the fact that it hasn't been initialized
     */

    fun setup() {
        anObject = AnObject()
    }

    fun testing() {
        anObject.toString()
    }

    // To check whether a lateinit var has already been initialized,
    // use .isInitialized on the reference to that property:
    val check = if (::anObject.isInitialized) {
        println("object is initialized")
    } else {
        println("object isn't initialized")
    }

}
