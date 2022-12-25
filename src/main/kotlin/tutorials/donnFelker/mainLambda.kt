fun main() {

    /* Lambda functions...
       format below
    *  val lambdaName: (inputType) -> ReturnType = { arguments:inputType -> body } */

    val greeter: (String) -> String = { name: String -> "Hello $name" }

    /* you don't need to specify the input and return type on the left
    *  if the function is returning a Unit */
    /*val greeter2 = { firstName: String, lastName: String ->
        val modifiedFirstName = firstName.toUpperCase()
        val modifiedLastName = lastName.toLowerCase()
        println("Hello $modifiedFirstName $modifiedLastName")
    }

    val greeting = greeter("Donn")
    val greeting2 = greeter2("Donn", "Felker")
    println(greeting)
    println(greeting2)
    println("---------------------------------------------------------")*/

    /* Lambda as a Function Parameter */
    /*lineLogger {
        println("message 1")
        println("message 2")
    }*/

    /*repeater(5) {index ->
        if(index< 3)
            println("Hello")
        else
            println("Goodbye")
    }*/

    /*derbyAnnouncer { player: String ->
        "$player is a great asset to the team."
    }*/

    /* you use 'it' when a lambda has 1 parameter */
    repeat(10) {
        println("This is iteration $it")
    }
}

fun derbyAnnouncer(block: (String) -> String) {
    val players = listOf(
        "McGwire",
        "Canseco",
        "Honeycutt",
        "Davis",
        "Dawley",
        "Weiss"
    )

    val randomPlayer = players.random()
    println("The next player is... $randomPlayer")
    val announcerMessage = block(randomPlayer)
    println(announcerMessage)
}

fun repeater(times: Int, block: (Int) -> Unit) {
    repeat(times) { index -> block(index) }
}

fun lineLogger(block: () -> Unit) {
    repeat(5) { println("-------") }
    block()
    repeat(5) { println("-------") }
}