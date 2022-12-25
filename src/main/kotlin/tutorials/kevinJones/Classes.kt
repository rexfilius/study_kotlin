data class Person(val name: String, var age: Int) {

    constructor(name: String, age: Int, city: String) : this(name, age)

    constructor(name: String, age: Int, city: String, isAfrican: Boolean)
            : this(name, age, city)
}

/**
 * Only provide more than one constructor if you are deriving from a class that
 * requires it
 */
data class Human(
    val name: String,
    var age: Int,
    var city: String = "Lagos",
    var isTall: Boolean = false,
    var isFat: Boolean = true,
    var isAfrican: Boolean = true,
)

fun main() {

    val aHuman = Human("aHuman", 10)
    val bHuman = Human("bHuman", 11, "Lagos")
    val cHuman = Human("cHuman", 12, "Abuja", isTall = true)
    val dHuman = Human("dHuman", 13, "Warri", isTall = true, isFat = false)
    val eHuman = Human(
        name = "eHuman", age = 14, city = "Ibadan",
        isTall = true, isFat = false, isAfrican = false
    )

    println(aHuman)
    println(bHuman)
    println(cHuman)
    println(dHuman)
    println(eHuman)

    val aPerson = Person("John", 32)
    println(aPerson)

    val bPerson = Person("John", 32, "Lagos")
    println(bPerson)

    val cPerson = Person("John", 32, "Lagos", true)
    println(cPerson)
}