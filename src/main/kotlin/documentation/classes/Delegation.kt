package classes

/**
 * The Delegation pattern has proven to be a good alternative to implementation
 * inheritance,and Kotlin supports it natively requiring zero boilerplate code. A class
 * Derived can implement an interface Base by delegating all of its public members
 * to a specified object
 */
interface Base5 {
    fun printName()
}

class BaseImpl(val name: String) : Base5 {
    override fun printName() = println(name)
}

/**
 * The by -clause in the supertype list for Derived indicates that b will be stored
 * internally in objects of Derived and the compiler will generate all the
 * methods of Base that forward to b
 */
class Derived5(b: Base5) : Base5 by b

/**
 * Overriding a member of an interface implemented by delegation:
 * Overrides work as you expect: the compiler will use your override implementations
 * instead of those in the delegate object
 */
interface Base6 {
    fun printName()
    fun printWelcome()
}

class BaseImpl2(val name: String) : Base6 {
    override fun printName() = println(name)

    override fun printWelcome() = println("Welcome $name")
}

class Derived6(b: Base6) : Base6 by b {
    override fun printName() = println("Jake")
}

fun main() {
    val b = BaseImpl("Jane")
    Derived5(b).printName()

    // overriding interface member implemented by delegation
    val name = BaseImpl2("Jake")
    Derived6(name).printName()
    Derived6(name).printWelcome()
}