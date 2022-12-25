package functions

fun main() {

    // Method 1
    val sb = StringBuilder()
    sb.appendln("Alphabet: ")
    for (c in 'a'..'z') {
        sb.append(c)
    }
    println(sb.toString())

    // Method 2
    val string = StringBuilder()
    with(string) {
        appendln("Alphabet: ")
        for (c in 'a'..'z') {
            append(c)
        }
        println(toString())
    }

    // 'buildString' is better than 'with'
    val alphabet: String = buildString {
        appendln("Alphabet: ")
        for (c in 'a'..'z') {
            append(c)
        }
    }
    println(alphabet)
}