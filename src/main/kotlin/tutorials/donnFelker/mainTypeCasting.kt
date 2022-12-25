fun main() {

    /* checking for type */
    val age = 32
    if (age is Any) {
        println("Is Any")
    } else {
        println("Not Any")
    }
    println("------------------------------------------------------")

    /* casting in Kotlin */
    val obj: Any = getStuff("2")
    val casted: String = obj as String // for safe casting -> 'as' becomes 'as?'
    println(casted)
}

fun getStuff(value: String): Any {
    return when (value) {
        "1" -> 99
        "2" -> "Hello"
        "3" -> true
        "4" -> 16.1
        "5" -> PersonZ("Donn")
        else -> false
    }
}

data class PersonZ(val name: String)