package higherOrderFunctions

data class Girly(val name: String, val age: Int)

/**
 * Using return in a regular loop
 */
fun lookForRonke(people: List<Girly>) {
    for (person in people) {
        if (person.name == "Ronke") {
            println("Found her")
            return
        }
    }
    println("Ronke is not found")
}

/**
 * - Using return in a lambda passed to forEach
 * - If you use the return keyword in a lambda, it returns from the function in which
 * you called the lambda, not just from the lambda itself. Such a return statement is
 * called a non-local return, because it returns from a larger block than the block
 * containing the return statement.
 * - Note that the return from the outer function is possible only if the function
 * that takes the lambda as an argument is inlined
 * - Using the return expression in lambdas passed to non-inline functions isn't allowed.
 */
fun lookForRonke2(people: List<Girly>) {
    people.forEach {
        if (it.name == "Ronke") {
            println("Found her")
            return
        }
    }
    println("Ronke is not found")
}

/**
 * - Using a local return with a label
 * - You can write a local return from a lambda expression as well. A local return in
 * a lambda is similar to a break expression in a for loop. It stops the execution of
 * the lambda and continues execution of the code from which the lambda was invoked.
 * - To distinguish a local return from a non-local one, you use labels. You can
 * label a lambda expression from which you want to return, and then refer to this
 * label after the return keyword.
 * - Alternatively, the name of the function that takes this lambda as an argument
 * can be used as a label. e.g. 'return@forEach'
 */
fun lookForRonke3(people: List<Girly>) {
    people.forEach labelName@{
        if (it.name == "Ronke")
            return@labelName
    }
    println("Ronke might be somewhere")  // this line is always printed
}

/**
 * - The non-local return syntax is fairly verbose and becomes cumbersome if a lambda
 * contains multiple return expressions. As a solution, you can use an alternate
 * syntax to pass around blocks of code: anonymous functions.
 * - an anonymous function looks similar to a regular function, except
 * that its name and parameter types are omitted
 */
fun lookForRonke4(people: List<Girly>) {
    people.forEach(fun(person) {
        if (person.name == "Ronke")
            return    // return refers to the closest function - an anonymous function
        println("${person.name} is not Ronke")
    })
}

/**
 * - Note that despite the fact that an anonymous function looks similar to a regular
 * function declaration, it's another syntactic form of a lambda expression.
 * The discussion of how lambda expressions are implemented and how they're inlined
 * for inline functions applies to anonymous functions as well.
 * - Anonymous functions provide an alternative syntax to lambda expressions with
 * different rules for resolving the return expressions. You can use them if you
 * need to write a block of code with multiple exit points.
 * */
fun main() {
    val girls = listOf(
        Girly("Tinuke", 23),
        Girly("Asake", 25),
        Girly("Joke", 24),
        Girly("Ronke", 27),
        Girly("Jumoke", 26)
    )

    lookForRonke(girls)
    println()
    lookForRonke3(girls)
    println()
    lookForRonke4(girls)
}