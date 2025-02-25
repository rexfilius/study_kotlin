package documentation.classes

/**
 * DATA CLASSES
 * The compiler automatically derives the ffg members from all properties declared in the
 * primary constructor: equals()/hashCode() pair, toString(), copy(),
 * componentN() functions corresponding to the properties in their order of declaration
 * ...
 * Data classes have the ffg requirements:
 * 1. the primary constructor needs to have at least one parameter
 * 2. all primary constructor parameters need to be marked as 'val' or 'var'
 * 3. they cannot be abstract, open, sealed or inner.
 */
data class User(val name: String, val age: Int)

/**
 * The compiler only uses the properties defined inside the primary constructor for the
 * automatically generated functions. To exclude a property from the generated
 * implementations, declare it inside the class body
 */
data class Person6(val name: String) {
    var age: Int = 0
}

fun main() {
    val person1 = Person6("John")
    val person2 = Person6("John")
    person1.age = 10
    person2.age = 20

    println("is person1 == person2? ${person1 == person2}")
    println()

    /**
     * To copy an object for changing some of its properties, but keeping the rest
     * unchanged, use the copy() function
     */
    val jack = User(name = "Jack", age = 10)
    val olderJack = jack.copy(age = 15)
    println(olderJack)

    /**
     * Component functions generated for data classes enable their use
     * in "destructuring declarations"
     */
    val jane = User("Jane", 35)
    val (name, age) = jane
    println("$name, $age years of age") // prints "Jane, 35 years of age"

}