fun main() {

    /* generics help you to encapsulate common functionalities
    *  across large swaths of code */
    val listOfStrings: List<String> = listOf("Donn", "John", "Mary")
    val listOfInts = listOf(1, 2, 3, 4, 5)
    val map = mapOf("Donn" to 32, "Tushar" to 42)

    /* creating a generic class */
    val result = EvenList(listOfStrings)
    println(result.evenItems())

    val result2 = EvenList(listOfInts)
    println(result2.evenItems())

    val people = listOf(
        PersonF("Donn"),
        PersonF("Bob"),
        PersonF("Mary"),
        PersonF("Felicia")
    )
    println(EvenList(people).evenItems())
}

data class PersonF(val name: String)

class EvenList<T>(val list: List<T>) {
    fun evenItems(): List<T> {
        return list.filterIndexed { index, value -> index % 2 == 0 }
    }
}