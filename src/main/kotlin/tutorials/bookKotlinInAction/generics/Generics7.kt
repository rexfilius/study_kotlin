package generics

/**
 * - A generic class e.g. MutableList - is called INVARIANT on the type parameter if,
 * for any two different types A and B, MutableList-A is not a subtype or a supertype
 * of MutableList-B. In Java, all classes are invariant.
 * - If A is a subtype of B, then List-A is a subtype of List-B. Such classes or
 * interfaces are called COVARIANT.
 * - A covariant class is a generic class (we’ll use Producer-T as an example) for
 * which the following holds: Producer-A is a subtype of Producer-B if A is a subtype
 * of B. We say that the subtyping is preserved. e.g. Producer-Cat is a subtype of
 * Producer-Animal because Cat is a subtype of Animal.
 * - In Kotlin, to declare the class to be covariant on a certain type parameter, you put
 * the 'out' keyword before the name of the type parameter.
 */
open class Animal {
    fun feed() {}
}

/**
 * - You can’t make any class covariant: it would be unsafe. Making the class covariant
 * on a certain type parameter constrains the possible uses of this type parameter in the
 * class. To guarantee type safety, it can be used only in so-called out positions,
 * meaning the class can produce values of type T but not consume them.
 * - Uses of a type parameter in declarations of class members can be divided into in
 * and out positions. Let’s consider a class that declares a type parameter T and contains
 * a function that uses T.
 * - We say that if T is used as the return type of function, it’s in the out position.
 * In this case, the function produces values of type T. If T is used as the type of
 * function parameter, it’s in the in position. Such a function consumes values of type T.
 * - NOTE:: The out keyword on a type parameter of the class requires that all methods
 * using T have T only in 'out' positions and not in 'in' positions. This keyword
 * constrains possible use of T, which guarantees safety of the corresponding subtype relation.
 * - NOTE:: Constructor parameters are in neither the in nor the out position. Even if a
 * type parameter is declared as out, you can still use it in a constructor parameter declaration
 */
class Herd<out T : Animal> {
    val size: Int get() = 5
    operator fun get(i: Int): T {
        return i as T    // placeholder code
    }
}

fun feedAll(animals: Herd<Animal>) {
    for (i in 0 until animals.size) {
        animals[i].feed()
    }
}

class Cat : Animal() {
    fun cleanLitter() {}
}

fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0 until cats.size) {
        cats[i].cleanLitter()
        feedAll(cats)    //Herd is covariant, so feedAll() can accept Animal and subtype
    }
}


