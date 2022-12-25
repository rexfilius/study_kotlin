package thirtyDaysOfCode

fun main() {
    val num = readln().toInt()

    when {
        num % 2 == 0 -> println("Weird")
        num % 2 == 0 && num in 2..6 -> println("Not Weird")
        num % 2 == 0 && num in 6..20 -> println("Weird")
        num % 2 == 0 && num > 20 -> println("Not Weird")
    }
}