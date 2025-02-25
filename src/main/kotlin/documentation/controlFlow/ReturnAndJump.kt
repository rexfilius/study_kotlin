package documentation.controlFlow

fun main() {

    /**
     * Kotlin has three structural jump expressions:
     * return = returns from the nearest enclosing function or anonymous function.
     * break = terminates the nearest enclosing loop.
     * continue = proceeds to the next step of the nearest enclosing loop.
     * All of these expressions can be used as part of larger expressions
     */

    /**
     * Any expression in Kotlin may be marked with a 'label'.
     * Labels have the form of an identifier followed by the '@' sign
     * ...
     * A 'break' qualified with a label jumps to the execution point right after the loop
     * marked with that label. A 'continue' proceeds to the next iteration of that loop
     */
    loop@ for (i in 1..20) {
        for (j in 20 downTo 1) {
            if (i == j) {
                print("$i. ")
                break@loop
            }
            print("$j..")
        }
    }
    println("\n")

    listOfNames()
    listOfNames2()
    listOfNames3()
    listOfNames4()
    listOfNames5()
    listOfNames6()

}

fun listOfNames() {
    listOf("Alice", "Jane", "Ron", "Jake", "Kate", "James").forEach {
        if (it.contains('J'))
            print("$it..")
    }
    println()
}

fun listOfNames2() {
    listOf("Alice", "Jane", "Ron", "Jake", "Kate", "James").forEach {
        if (it.contains('J')) return
        println(it)
    }
    println()
}

// To return from a lambda expression, label it and qualify the 'return'
fun listOfNames3() {
    listOf("Alice", "Jane", "Ron", "Jake", "Kate", "James").forEach containsJ@{
        if (it.contains('J')) return@containsJ
        print("$it..")
    }
    println("done with explicit label")
}

fun listOfNames4() {
    listOf("Alice", "Jane", "Ron", "Jake", "Kate", "James").forEach {
        if (it.contains('J')) return@forEach
        print("$it..")
    }
    println("done with implicit label")
}

// You can replace the lambda expression with an anonymous function. A 'return'
// statement in an anonymous function will return from the anonymous function itself
fun listOfNames5() {
    listOf("Alice", "Jane", "Ron", "Jake", "Kate", "James").forEach(fun(value: String) {
        if (value.contains('J')) return
        print("$value..")
    })
    println("done with anonymous function")
}

fun listOfNames6() {
    run loop@ {
        listOf("Alice", "Jane", "Ron", "Jake", "Kate", "James").forEach {
            if (it.contains('J')) return@loop
            print("$it..")
        }
    }
    println("done with nested loop")
}