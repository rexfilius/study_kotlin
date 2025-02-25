package documentation.classes

/**
 * Kotlin provides an ability to extend a class with new functionality without having
 * to inherit from the class or use design patterns such as Decorator. This is done
 * via special declarations called extensions. There are also extension properties
 * that let you define new properties for existing classes.
 */

// swap - an extension function
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val temp = this[index1]   // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = temp
}

// swap - a generic extension function
fun <T> MutableList<T>.swap2(index1: Int, index2: Int) {
    val temp = this[index1]   // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = temp
}

/**
 * Extensions do not actually modify classes they extend. By defining an extension,
 * you do not insert new members into a class, but merely make new functions callable
 * with the dot-notation on variables of this type. Extension functions are dispatched
 * statically, that means that they are not virtual by receiver type. An extension
 * function being called is determined by the type of the expression on which the
 * function is invoked, not by the type of the result of evaluating that expression
 * at runtime...the code below prints Shape because the called extension function depends
 * only on the declared type of the parameter 's', which is the Shape class.
 */
open class Shape3
class Rectangle6 : Shape3()

fun Shape3.getName() = "Shape"
fun Rectangle6.getName() = "Rectangle"
fun printClassName(s: Shape3) = println(s.getName())

/**
 * If a class has a member function, and an extension function is defined which has
 * the same receiver type, the same name, and is applicable to given arguments,
 * the member always wins
 */
class Example2 {
    fun printFunctionType() = println("Class method")
}

fun Example.printFunctionType() = println("Extension function")

// it's OK for extension functions to overload member functions which
// have the same name but different signature
fun Example2.printFunctionType(i: Int) = println("Extension Function $i")


fun main() {

    val list = mutableListOf(1, 2, 3)
    list.swap(0, 2)
    println(list)

    val names = mutableListOf("Jon", "Yon", "Ron", "Jak")
    names.swap2(1, 3)
    println(names)

    println()
    printClassName(Rectangle6())
    Example2().printFunctionType()
    Example2().printFunctionType(2)
}

