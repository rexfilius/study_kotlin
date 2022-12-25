fun main() {

    /* throwing an Exception in Kotlin */
    /*val p = PersonS("Donnie", 13)
    if (p.age < 18) {
        throw InvalidAgeException(p.age, "User is not old enough")
    }*/

    /* try-catch statement */
    val p = PersonS("Donnie", 13)
    try {
        checkAge(p)
        println("Done")
    } catch (ex: Exception) {
        println("caught the exception")
    }

}

private fun checkAge(p: PersonS) {
    if (p.age < 18) {
        throw InvalidAgeException(p.age, "Boom")
    }
}

/* a custom exception
*  you can extend any class of exception you want to */
class InvalidAgeException(val age: Int, message: String)
    : IllegalArgumentException("Invalid age: $age, $message")

data class PersonS(val name: String, val age: Int)