package controlFlow

import getAString
import getAnInt
import getAnyObject

fun main() {

    /**
     * 'when' defines a conditional expression with multiple branches. it is
     * similar to the switch statement in C-like languages.
     */
    when (getAnyObject()) {
        1 -> print("typeSystem.getX == 1")
        2 -> print("typeSystem.getX == 2")
        else -> {
            print("typeSystem.getX is neither 1 nor 2")
        }
    }

    // To define a common behaviour for multiple cases, combine their conditions
    // in a single line with a comma
    when (getAnyObject()) {
        2, 3 -> print("y == 2 or y == 3")
        else -> print("otherwise")
    }

    // You can also check a value for being 'in' or '!in' a range or a collection
    when (getAnInt()) {
        in 1..10 -> print("number is in the range")
        !in 10..20 -> print("number is outside the range")
        else -> print("none of the above")
    }

    /**
     * 'when' can be used as a replacement for an if-else-if chain. if no argument
     * is supplied, the branch conditions are simply boolean expressions, and a branch
     * is executed when its condition is true
     */
    val code = getAString()
    when {
        code.isEmpty() -> print("code is empty")
        code.isNotEmpty() -> print("code is not empty")
        else -> print("code is code")
    }
}

/**
 * Using 'when' - another option is checking that a value 'is' or '!is' of a particular
 * type. NOTE - due to smart casts, you can access the methods and properties
 * of the type without any extra checks
 */
fun hasPrefix(x: Any) = when (x) {
    is String -> x.startsWith("prefix")
    else -> false
}

// You can capture 'when' subject in a  variable using following syntax
fun getSome() = when (val some = getAString()) {
    "Code" -> some.length
    else -> some.toUpperCase()
}