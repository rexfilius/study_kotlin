package classes

fun main() {

    /* 'when' statement */
    /*val user = User("Don", "Felker")

    when (user.firstName) {
        "Donn" -> println("This is Donn")
        else -> println("This is not Donn")
    }*/

    /* data classes */
    /*val p1 = Person("Donn", "Felker")
    val p2 = Person("Donn", "Felker")
    val p3 = Person()

    println(p1 == p2)
    println(p1.nameLength())
    println(p3)
    println("--------------------------")
    println(p1.component1())
    println(p1.component2())
    println("---------------------------")

    val (firstName, lastName) = p1 // destructuring
    println(firstName)
    println(lastName)
    println("----------------------------")

    val sibling = p1.copy()
    println(p1)
    println(sibling)
    println("Is p1 equals sibling? ${p1==sibling}")*/

    /* Pair and Triple classes..
    *  they are in-built data classes,
    *  and the parameters in their constructors don't have to be the same type */
    /*val pair = Pair("Joe", "Rogan")
    val pair2 = "Jack" to "Lee"
    println(pair)

    val triple = Triple("Jack", "Jason", "Lee")*/

    /* protected modifier for variables and functions */
    /*val p = Human("Donn", 23)
    //p.favoriteFood = "Watermelon"
    val c= Chef("Bob", 33, "Ribs")
    p.printMyFavoriteFood()
    c.printMyFavoriteFood()
    c.setMyFavoriteFood("Celery")
    c.printMyFavoriteFood()*/

}

/* Data Classes...
*  parameters in a data class constructor must be val or var
*  you can make a data class have parameterless constructor -
*  you do this by making the parameters have default values,
*  so when it is instantiated, the constructor would have no parameters.*/
data class Person(val firstName: String = "Joe", var lastName: String = "Lee") {
    fun fullName(): String {
        return "$firstName $lastName"
    }

    fun nameLength(): Int = fullName().length
}