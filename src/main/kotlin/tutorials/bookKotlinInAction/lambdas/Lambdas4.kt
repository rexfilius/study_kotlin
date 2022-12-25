package lambdas

fun salute() = println("Salute")

fun PersonG.isAdult() = age >= 21

fun main() {
    /**
     * You can have a reference to a function that's declared at the top level
     * (and isn't a member of a class)
     */
    run(::salute)
    println("...")

    /**
     * You can store or postpone the action of creating an instance of a class using
     * a constructor reference. The constructor reference is formed by specifying the
     * class name after the double colons.
     */
    val createPerson = ::PersonG
    val pg = createPerson("Joe", 40)
    println(pg)

    /**
     * Note that you can also reference extension functions the same way
     */
    val pred = PersonG::isAdult

    /**
     * Bound References:: allows you to use the member-reference syntax to capture
     * a reference to the method on a specific object instance.
     */
    val bob = PersonG("Bob", 15)
    val bobsAge = bob::age
    println(bobsAge())
}
