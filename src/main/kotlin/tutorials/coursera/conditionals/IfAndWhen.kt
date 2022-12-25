package conditionals

enum class Color {
    BLUE, RED, ORANGE
}

fun getDescription(color: Color): String = when(color) {
        Color.BLUE -> "cold"
        Color.ORANGE -> "mild"
        Color.RED -> "hot"
    }

fun respondToInput(input: String) = when(input) {
    "y", "yes" -> "I am glad you agree"
    "n", "no" -> "Sorry to hear that"
    else -> "I do not understand you"
}

fun main() {
    println(respondToInput("y"))
    println(getDescription(Color.RED))
}