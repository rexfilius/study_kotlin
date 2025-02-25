package documentation.classes

import AnObject

/**
 * An interface can derive from other interfaces and thus both provide implementations
 * for their members and declare new functions and properties.
 * Quite naturally, classes implementing such an interface
 * are only required to define the missing implementations
 */
interface Named {
    val name: String
}

interface Person5 : Named {
    val firstName: String
    val lastName: String

    override val name: String
        get() = "$firstName $lastName"
}

data class Employee(
    // implementing 'name' from 'Named' interface isn't required
    override val firstName: String,
    override val lastName: String,
    val anObject: AnObject
) : Person5