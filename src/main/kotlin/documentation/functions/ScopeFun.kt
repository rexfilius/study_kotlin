package documentation.functions

import kotlin.random.Random

/**
 * The Kotlin standard library contains several functions whose sole purpose is to execute
 * a block of code within the context of an object. When you call such a function on an
 * object with a lambda expression provided, it forms a temporary scope. In this scope,
 * you can access the object without its name. Such functions are called scope functions.
 * There are five of them: let, run, with, apply, also.
 * ...
 * Basically, these functions do the same: execute a block of code on an object.
 * What's different is how this object becomes available inside the block and what is
 * the result of the whole expression.
 */
fun main() {

    // typical usage of a scope function
    Human("Alice", 20, "Amsterdam").let {
        println(it)
        it.moveTo("London")
        it.incrementAge()
        println(it)
    }
    println()

    // without scope function - you introduce a new variable
    val alice = Human("Alice", 20, "Amsterdam")
    println(alice)
    alice.moveTo("London")
    alice.incrementAge()
    println(alice)
    println()

    /**
     * Because the scope functions are all quite similar in nature, it's important to
     * understand the differences between them. There are two documentation.documentation.documentation.documentation.documentation.documentation.documentation.documentation.documentation.documentation.documentation.documentation.documentation.documentation.typeSystem.main differences between
     * each scope function:
     * [1] The way to refer to the context object.
     * [2] The return value.
     * ...
     * Inside the lambda of a scope function, the context object is available by a short
     * reference instead of its actual name. Each scope function uses one of two ways to
     * access the context object: as a lambda receiver (this) or as a lambda argument (it).
     * Both provide the same capabilities.
     */
    val str = "Hello"
    str.run {
        println("The receiver string length: $length")
        println("The receiver string length: ${this.length}") // does the same
    }

    str.let {
        println("The receiver string's length is ${it.length}")
    }
    println()

    // CONTEXT OBJECT
    /**
     * "this"
     * RUN, WITH, and APPLY, refer to the context object as a lambda receiver -
     * by keyword this. Hence, in their lambdas, the object is available as it would be in
     * ordinary class functions. In most cases, you can omit this when accessing the
     * members of the receiver object, making the code shorter. On the other hand,
     * if this is omitted, it can be hard to distinguish between the receiver members and
     * external objects or functions. So, having the context object as a receiver (this)
     * is recommended for lambdas that mainly operate on the object members:
     * call its functions or assign properties.
     */
    val adam = Human("Adam").apply {
        this.age = 20
        this.city = "London"
    }
    println(adam)
    println()

    /**
     * "it"
     * LET and ALSO have the context object as a lambda argument. If the argument name is
     * not specified, the object is accessed by the implicit default name it. it is shorter
     * than this and expressions with it are usually easier for reading. However, when
     * calling the object functions or properties you don't have the object available
     * implicitly like this. Hence, having the context object as it is better when the
     * object is mostly used as an argument in function calls. it is also better if you
     * use multiple variables in the code block. Additionally, you can provide a custom name
     * for the context object inside the scope
     */
    val i = getRandomInt()
    val j = getRandomInt2()
    println()

    // RETURN VALUE
    /**
     * The return value of APPLY and ALSO is the context object itself. Hence, they can be
     * included into call chains as side steps: you can continue chaining function calls
     * on the same object after them. They also can be used in return statements of
     * functions returning the context object. e.g. [getRandomInt]
     */
    val numberList = mutableListOf<Double>()
    numberList.also { println("Populating the list") }
            .apply {
                add(2.71)
                add(3.14)
                add(1.0)
            }
            .also { println("Sorting the list") }
            .sort()
    println()

    /**
     * LET, RUN, and WITH return the lambda result. So, you can use them when assigning
     * the result to a variable, chaining operations on the result, etc. Additionally, you
     * can ignore the return value and use a scope function to create a temporary
     * scope for variables.
     */
    val numbers = mutableListOf("one", "two", "three")
    val countEndsWithE =
            numbers.run {
                add("four")
                add("five")
                count { it.endsWith("e") }
            }
    println("There are $countEndsWithE elements that end with e.")
    println()

    val bNumbers = mutableListOf("one", "two", "three")
    with(bNumbers) {
        val firstItem = first()
        val lastItem = last()
        println("First item: $firstItem, last item: $lastItem")
    }

}

data class Human(val name: String, var age: Int = 0, var city: String = "") {

    fun incrementAge() = age++

    fun moveTo(newCity: String) {
        city = newCity
    }
}

fun getRandomInt(): Int {
    return Random.nextInt(100).also {
        writeToLog("getRandomInt() generated value $it")
    }
}

fun getRandomInt2(): Int {
    return Random.nextInt(100).also { value ->
        writeToLog("getRandomInt() generated value $value")
    }
}

fun writeToLog(s: String) = println(s)