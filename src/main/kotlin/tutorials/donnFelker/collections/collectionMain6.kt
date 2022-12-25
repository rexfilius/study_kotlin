package collections

fun main() {

    /* List vs Set vs Map vs Sequence */
    /*val list = listOf("Donn", "Tushar", "Kavita", "Evelyn", "Felicia")

    val set = setOf("Donn", "Tushar", "Donn", "Tushar") // set doesn't allow duplicate

    val map = mapOf("Donn" to "Felker", "Tushar" to "Muhaj", "Evelyn" to "Smith")

    /* you use sequence when you need something(a large list) with high performance */
    val sequence = sequenceOf(1, 2, 3, 4, 5)*/

    /* kotlin doesn't have a ternary operator
    *  use a single-line if-else statement instead */
    /*var name: String? = "Donn"
    val length = if (name != null) name.length else { 0 }
    //val length = name?.length ?: 0 // same as above statement but with Elvis operator
    println(length)
    println("-------------------------------------------------------")*/

    /* Double Bang operator - use it less */
    /*var name2: String? = "Donn"
    val length2 = name2!!.length
    println(length2)
    println("---------------------------------------------------------")*/

    /* requireNotNull() function */
    /*var name3: String? = "Donn"
    val length3 = requireNotNull(name3, { "The name should not be null, but it was!"}).length
    println(length3)
    println("----------------------------------------------------------")*/

    /* checkNotNull() function - same as requireNotNull() */
    /*val person: PersonX? = PersonX("John")

    if (checkNotNull(person).name == "Donn") {
        println("Hi Donn!")
    } else {
        println("Hi")
    }*/

    /* filterNotNull() function */
    val names = listOf("Donn", "John", "Mike", null, "Davita", "Jenn", null, "Mihta")
    println(names.filterNotNull())
}

class PersonX(val name: String)