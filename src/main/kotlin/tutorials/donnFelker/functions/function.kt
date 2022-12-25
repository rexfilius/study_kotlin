package functions

fun main() {

    // returning a value from a function
    /*var x = helloWorld()
    println(x)
    println(helloWorld())
    println("--------------------------------")

    var y = hello()
    println(y)*/

    // creating a function in a function
    //sayHiAndBye()

    // single-line-expression function
    //sayHi()

    // kotlin function arguments
    /*doWork( 34, "Kel")
    drinkBeer("Jon", 35)
    drinkBeer("Kel", 18)*/

    // named parameters in a function
    // the named parameters do not have to be in the default position
    /*printUserInfo(
        age = 32, firstName = "Kel", lastName = "Joe",
        isSunBurned = false, lovesPopcorn = true, likeMovies = true
    )*/

    /* default arguments in a function
    * the last 2 args are DEFAULT... no need writing it out
    * however, if the args ned to be different from the DEFAULT,
    * you can write it out
    * ... and I just discovered you can use named args and positional args
    * when you have a default args in your function*/
    /*printUserInfo2("Jon", "Snow", 32, true)
    printUserInfo2("Sam", "Well", 30, false, likeMovies = false)*/

    /*providing multiple arguments of the same type,
    * using 'vararg' keyword*/
    /*printBookInfo("Green Eggs and Ham", "Dr Seuss", "Joe Kel")
    printBookInfo("Almanack of Naval")*/

    /*function overloading
    * ..instead of declaring the same function with different args
    * you just declare one function, and make some args to be default
    * and that is how you overload a function in Kotlin*/
    printInfo("Jon Snow")
    printInfo("Sam Well", 34)
}

/*by default, all functions that do not have a return type,
* return Unit */

fun helloWorld() {
    println("hello World")
}

fun hello(): String {
    return "Hello"
}

fun sayHiAndBye() {
    println("Hi")

    fun sayBye() {
        println("Bye")
    }

    sayBye()
}

fun sayHi() = println("Hi")

fun doWork(age: Int, name: String) {
    println("$name, you are $age years old")
}

fun drinkBeer(name: String, age: Int) {
    if (age < 21) {
        println("$name, you are too young to be drinking beer")
    } else {
        println("$name, grab yourself a cold bottle of your favorite beer")
    }
}

fun printUserInfo(
    firstName: String, lastName: String, age: Int,
    isSunBurned: Boolean, likeMovies: Boolean, lovesPopcorn: Boolean
) {

    println(
        "$firstName $lastName is of age $age. Sunburned: $isSunBurned. " +
                "Likes movies: $likeMovies. Loves popcorn: $lovesPopcorn"
    )
}

fun printUserInfo2(
    firstName: String, lastName: String, age: Int,
    isSunBurned: Boolean, likeMovies: Boolean = true, lovesPopcorn: Boolean = true
) {

    println(
        "$firstName $lastName is of age $age. Sunburned: $isSunBurned. " +
                "Likes movies: $likeMovies. Loves popcorn: $lovesPopcorn"
    )
}

fun printBookInfo(title: String, vararg author: String) {
    println("$title - Author: ")
    author.forEach { println(it) }
}

fun printInfo(name: String, age: Int = 0) {
    println("Name: $name, Age: $age")
}

