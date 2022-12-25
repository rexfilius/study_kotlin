package lambdas

/**
 * When you declare an anonymous inner class in a function, you can refer to parameters
 * and local variables of that function from inside the class. With lambdas, you can do
 * exactly the same thing. If you use a lambda in a function, you can access the
 * parameters of that function as well as the local variables declared before the
 * lambda. We can demonstrate this using the forEach standard library function.
 */
fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("$prefix $it")
    }
}

/**
 * One important difference between Kotlin and Java is that in Kotlin, you are not
 * restricted to accessing non-final variables. You can also modify variables from
 * within a lambda. External variables accessed from a lambda,
 * are said to be captured by the lambda.
 */
fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach {
        if (it.startsWith("4"))
            clientErrors++
        else if (it.startsWith("5"))
            serverErrors++
    }
    println("$clientErrors client errors, $serverErrors server errors.")
}

fun main() {
    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessagesWithPrefix(errors, "Error:")
    println()

    val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
    printProblemCounts(responses)
}