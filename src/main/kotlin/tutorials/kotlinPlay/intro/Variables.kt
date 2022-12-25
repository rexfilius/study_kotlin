package intro

/**
 * Kotlin has powerful type inference. While you can explicitly declare the type of a
 * variable, you'll usually let the compiler do the work by inferring it. Kotlin does not
 * enforce immutability, though it is recommended. In essence use val over var.
 */
fun main() {

    /**
     * Declares a mutable variable and initializes it
     */
    var a: String = "initial"
    println(a)

    /**
     * Declares an immutable variable and initializes it
     */
    val b: Int = 1

    /**
     * Declares an immutable variable and initializes it without specifying the type.
     * The compiler infers the type 'Int'
     */
    val c = 3

    /**
     * Declares a variable without initialization. An attempt to use the variable
     * causes a compiler error
     */
    var e: Int
    //println(e)

    /**
     * You're free to choose when you initialize a variable, however, it must be initialized
     * before the first read
     */
    val d: Int
    if (someCondition()) d = 1
    else d = 2
    println(d)
}

fun someCondition() = true