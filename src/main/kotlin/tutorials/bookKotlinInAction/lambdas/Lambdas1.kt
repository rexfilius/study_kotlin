package lambdas

/**
 * - Lambda expressions, or simply lambdas, are essentially small chunks of code that
 * can be passed to other functions. With lambdas, you can easily extract common code
 * structures into library functions, and the Kotlin standard library makes heavy use
 * of them. One of the most common uses for lambdas is working with collections.
 */
data class PersonG(val name: String, val age: Int)

// Searching through a collection manually
fun findTheOldest(people: List<PersonG>) {
    var maxAge = 0
    var theOldest: PersonG? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println("The oldest is : $theOldest")
}

fun main() {
    val people = listOf(
        PersonG("Alice", 29),
        PersonG("Bob", 32),
        PersonG("Jake", 42)
    )
    findTheOldest(people)

    // Searching through a collection using a lambda
    val people2 = listOf(
        PersonG("Alice", 29),
        PersonG("Bob", 32),
        PersonG("Jake", 42)
    )
    println(people2.maxByOrNull {
        it.age
    })

    /**
     * If a lambda just delegates to a function or property, it can be replaced
     * by a member reference.
     * code below: Searching using a member reference
     */
    val people3 = listOf(
        PersonG("Alice", 29),
        PersonG("Bob", 32),
        PersonG("Jake", 42)
    )
    println(people3.maxByOrNull(PersonG::age))
}