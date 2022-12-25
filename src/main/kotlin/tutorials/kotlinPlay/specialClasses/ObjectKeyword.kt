package specialClasses

import newLine
import java.util.Random

/**
 * Classes and objects in Kotlin work the same way as in most object-oriented languages:
 * a class is a blueprint, and an object is an instance of a class. Usually, you define a
 * class and then create multiple instances of that class.
 */
class LuckDispatcher {
    fun getNumber() {
        val objRandom = Random()
        println(objRandom.nextInt(90))
    }
}

/**
 * In Kotlin, you use the object keyword to obtain a data type with a single implementation
 * no class, no constructor, only a lazy instance. Why lazy? Because it will be created
 * once when the object is accessed. Otherwise it won't be created. The function below
 * uses an 'object expression'.
 */
fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int) {

    // creates an object to use when calculating the result value
    val dayRates = object {
        var standard: Int = 30 * standardDays
        var festivity: Int = 50 * festivityDays
        var special: Int = 100 * specialDays
    }

    // accesses the object's properties
    val total = dayRates.standard + dayRates.festivity + dayRates.special

    // prints the result
    print("Total price: $total")
}

/**
 * You can also use the object declaration. It isn't an expression, and can't be used in a
 * variable assignment. You should use it to directly access its members
 */
object DoAuth {
    fun takeParams(username: String, password: String) {
        println("input Auth parameters = $username:$password")
    }
}

/**
 * An object declaration inside a class defines another useful case: the companion object.
 * Syntactically it's similar to the static methods in Java: you call object members using
 * its class name as a qualifier. If you plan to use a companion object in Kotlin,
 * consider using a package-level function instead.
 */
class BigBen {
    companion object Bonger {    // name of companion object can be omitted
        fun getBongs(nTimes: Int) {
            for (i in 1..nTimes) {
                print("BONG ")
            }
        }
    }
}

object Bonger {
    fun getBongs(nTimes: Int) {
        for (i in 1..nTimes) {
            print("BONG ")
        }
    }
}

fun main() {

    val d1 = LuckDispatcher()
    val d2 = LuckDispatcher()
    d1.getNumber()
    d2.getNumber()
    "" newLine ""

    // calls the function rentPrice() and this is when the object is actually created
    rentPrice(10, 2, 1)

    DoAuth.takeParams("foo", "qwerty")
    "" newLine ""

    // companion object in a class
    BigBen.getBongs(12)

    // package level object
    Bonger.getBongs(12)
}