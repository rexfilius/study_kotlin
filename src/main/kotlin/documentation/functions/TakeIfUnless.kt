package documentation.functions

import newLine
import java.util.*
import kotlin.random.Random

fun main() {

    /**
     * In addition to scope functions, the standard library contains the functions
     * takeIf and takeUnless. These functions let you embed checks of the object state
     * in call chains.
     * When called on an object with a predicate provided:
     * ...
     * takeIf returns this object if it matches the predicate. Otherwise, it returns null.
     * So, takeIf is a filtering function for a single object.
     * ...
     * takeUnless returns the object if it doesn't match the predicate and null if it does.
     * The object is available as a lambda argument (it).
     */
    val number = Random.nextInt(100)

    val evenOrNull = number.takeIf { it % 2 == 0 }
    val oddOrNull = number.takeUnless { it % 2 == 0 }
    println("even: $evenOrNull, odd: $oddOrNull")
    "" newLine ""

    /**
     * When chaining other functions after takeIf and takeUnless, don't forget to perform
     * the null check or the safe call (?.) because their return value is nullable.
     */
    val str = "Hello"
    val caps = str.takeIf { it.isNotEmpty() }?.uppercase(Locale.getDefault())
    println(caps)
    "" newLine ""

    displaySubstringPosition("010000011", "11")
    displaySubstringPosition("010000011", "12")
    "" newLine ""

}

/**
 * takeIf and takeUnless are especially useful together with scope functions. A good
 * case is chaining them with let for running a code block on objects that match the
 * given predicate. To do this, call takeIf on the object and then call let with a
 * safe call (?). For objects that don't match the predicate, takeIf returns null and
 * let isn't invoked.
 */
fun displaySubstringPosition(input: String, sub: String) {
    input.indexOf(sub)
            .takeIf { it >= 0 }
            ?.let {
                println("The substring $sub is found in $input.")
                println("Its start position is $it.")
            }
}

// rewriting displaySubstringPosition
fun displaySubstringPosition2(input: String, sub: String) {
    val index = input.indexOf(sub)
    if (index >= 0) {
        println("The substring $sub is found in $input.")
        println("Its start position is $index.")
    }
}