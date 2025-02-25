package documentation.exceptions

fun main() {

    /**
     * All exception classes in Kotlin inherit the class 'Throwable'. Every exception
     * has a message, a stack trace and an optional clause.
     * ...
     * Kotlin does not have checked exceptions unlike Java.
     */
    //throw Exception("Hi There")

    // There may be zero or more catch blocks. 'finally' block may be omitted.
    // However, at least one catch or finally block should be present.
    try {
        val num = 1 / 0
    } catch (e: Exception) {
        println("error: ${e.message}")
    } finally {
        println("was trying to divide by zero")
    }


}