import kotlin.random.Random

fun main() {

    println("Hello World")

    // val keyword is for read-only variable
    // var keyword is for mutable variable
    var myName = "Ify Osakwe"
    println("myName: $myName")

    myName = "Kelvin Osakwe"
    println("myName: $myName")

    myName = ""
    println("myName: $myName")
    println("is myName empty?: ${myName.isEmpty()}")
    println()

    // specifying data types in Kotlin
    val fullName = "Ify Kel"
    println("\"$fullName\" class: ${fullName::class}")

    // number type in Kotlin
    val myByte: Byte = 8    // 8-bit signed integer
    val myShort: Short = 16 // 16-bit signed integer
    val myInt: Int = 32    // 32-bit signed Integer
    val myLong: Long = 64    // 64-bit signed Integer
    val myFloat: Float = 32.00f    // 32-bit floating point number
    val myDouble: Double = 64.00   // 64-bit floating point number

    println("\"$myByte\" class: ${myByte.toLong()::class}")
    println()

    // Strings and Char in Kotlin. In Kotlin, Char is a 16-bit Unicode Character
    val hisName = "Kel Jake"
    println(hisName.decapitalize())
    println(hisName.toLowerCase())

    val c = "Joy"
    println("Hello $c")
    println()

    val message: String = """
        Hello
        My name is John
        How are you?
    """.trimIndent()
    println(message)
    println()

    // you can have a single line if-else statement
    // as long as it isn't long to be unreadable
    val calories = 500
    if (calories > 2000) {
        println("You have consumed enough for the day")
    } else {
        println("You still have some calories left")
    }

    // == & === ... structural & referential equality
    val n1 = "Donn"
    val n2 = "Kelly"
    println("$n1 == $n2: ${n1 == n2}") // structural equality

    val a = 12
    val b = 12
    println("$a == $b: ${a == b}")

    val aa = Person("Donn")
    val bb = Person("Donn")
    println(aa === bb)    // referential equality
    println()

    //Nullable types
    /*var name: String = "Donn"
    name = null

    var name2: String? = "Donn"
    name2 = null

    var person1 = Person("Korg")
    person1 = null

    var person2: Person? = Person("Joe")
    person2 = null*/

    // Nullable Safe Calls
    val fName = "Donn"
    val l1 = fName.length

    val lName: String? = getAStringNull()
    var l2 = lName?.length // 2 answers = 'null' or 'actual length of string'

    var l3 = if (lName != null) lName.length else 0
    var l4 = lName?.length ?: 0 // shorthand of line above

    // Elvis Operator
    val lastName: String? = getAStringNull()
    val length: Int = lastName?.length ?: 0 // if lastName is 'null' return '0'

}

class Person(var name: String)