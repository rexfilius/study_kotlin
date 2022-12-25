package thirtyDaysOfCode

class Person(initialAge: Int) {
    var age: Int = 0

    init {
        if (initialAge < 0) {
            age = 0
            println("Age is not valid, setting age to 0.")
        } else {
            age = initialAge
        }
    }

    fun amIOld() {
        when {
            age < 13 -> println("You are young.")
            age in 13..17 -> println("You are a teenager.")
            else -> println("You are old.")
        }
    }

    fun yearPasses() {
        age += 1
    }

}

fun main() {
    val t = readln().toInt()

    for (i in 0..t) {
        val age = readln().toInt()
        val p = Person(age)
        p.amIOld()

        for (j in 0..3) {
            p.yearPasses()
        }
        p.amIOld()
        println("")
    }
}