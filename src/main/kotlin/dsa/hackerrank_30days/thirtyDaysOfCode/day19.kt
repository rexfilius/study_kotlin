package thirtyDaysOfCode

interface AdvancedArithmetic {
    fun divisorSum(number: Int): Int
}

class Calculator : AdvancedArithmetic {
    override fun divisorSum(number: Int): Int {
        var sum = 0
        for (i in 1..number) {
            if (number % i == 0)
                sum += i
        }
        return sum
    }
}

fun main() {
    val inputNumber = readln().toInt()
    val myCalculator = Calculator()
    val s = myCalculator.divisorSum(inputNumber)
    print("sum of divisors of $inputNumber = $s")
}