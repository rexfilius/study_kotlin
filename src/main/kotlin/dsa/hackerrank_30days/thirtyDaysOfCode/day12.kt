package thirtyDaysOfCode

open class PersonT(
    open val firstName: String,
    open val lastName: String,
    open val idNumber: Int
) {
    fun printPerson() {
        println("Name: $lastName, $firstName")
        println("ID: $idNumber")
    }
}

class StudentT(
    override val firstName: String,
    override val lastName: String,
    override val idNumber: Int,
    private val scores: List<Int>
) : PersonT(firstName, lastName, idNumber) {

    fun calculate(): Char {
        val grade = scores.sum() / scores.size
        return when {
            grade in 90..100 -> 'O'
            grade in 80..90 -> 'E'
            grade in 70..80 -> 'A'
            grade in 55..70 -> 'P'
            grade in 40..55 -> 'D'
            grade < 40 -> 'T'
            else -> '-'
        }
    }
}

fun main() {
    val line= generateSequence(::readLine)
    val dre = line.toList()

    val firstName = dre[0]
    val lastName = dre[1]
    val idNumber = dre[2].toInt()

    val personT = PersonT(firstName, lastName, idNumber)
    personT.printPerson()
}