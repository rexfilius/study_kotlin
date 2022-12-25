package intro

fun main() {

    println("hello there!")

    val question1 = 12 % 5
    println(question1)

    print("What's your name?: ")
    val name = readLine()
    println("hello $name")

    val decimalNumber = 10.6
    val floatNumber = 10.6f
    val answerDouble = decimalNumber * 3
    val answerFloat = floatNumber * 3
    println("Double: $answerDouble")
    println("Float: $answerFloat")

    // when takes only one condition, unlike
    // if that takes more than one condition
    println("Whats your level of pain between 1 and 3")
    when(readLine()?.toInt()) {
        1 -> println("Be calm, everything's going be fine")
        2 -> println("Do you need a doctor?")
        3 -> println("call 911 asap")
        else -> println("Wrong answer. I guess you pain is really painful")
    }

}