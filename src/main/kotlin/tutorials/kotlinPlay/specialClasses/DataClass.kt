package specialClasses

import newLine

/**
 * Data classes make it easy to create classes that are used to store values. Such classes
 * are automatically provided with methods for copying, getting a string representation,
 * and using instances in collections.
 */
data class User(val name: String, val id: Int)

fun main() {

    /**
     * toString is auto-generated for a data class, which makes the println output nice
     */
    val user = User("Alex", 1)
    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)
    println("user: $user")
    println("secondUser: $secondUser")
    println("thirdUser: $thirdUser")
    "" newLine ""

    /**
     * auto-generated equals considers two instances equal if all their
     * properties are equal
     */
    println("user == secondUser: ${user == secondUser}")
    println("user == thirdUser: ${user == thirdUser}")
    "" newLine ""

    // equal data class instances have equal hashCode().
    println("user hashCode: ${user.hashCode()}")
    println("secondUser hashCode: ${secondUser.hashCode()}")
    "" newLine ""

    /**
     * Auto-generated copy function makes it easy to create a new instance.
     * When copying, you can change values of certain properties. copy accepts arguments
     * in the same order as the class constructor.
     * Use copy with named arguments to change the value despite the properties order
     */
    println("user copy: ${user.copy()}")
    println("another copy: ${user.copy("Max")}")
    println("another copy: ${user.copy(id = 2)}")
    "" newLine ""

    /**
     * Auto-generated componentN functions let you get the values of properties in
     * the order of declaration.
     */
    println("name = ${user.component1()}")
    println("id = ${user.component2()}")

}