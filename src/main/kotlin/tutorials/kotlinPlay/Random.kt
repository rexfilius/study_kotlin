fun getAnObject() {

}

fun getAnyObject() : Any {
    return getAnObject()
}

fun getAString(): String {
    return ""
}

fun getAStringNull(): String? {
    return null
}

fun String.getAStringNullExt(): String? {
    return null
}

fun getAnInt(): Int {
    return 2 * 3
}

fun getABooleanTrue(): Boolean {
    return true
}

fun getABooleanFalse(): Boolean {
    return false
}

fun getAChar(): Char {
    return 'c'
}

infix fun String.newLine(s: String) {
    println(s)
}

class AnObject() {}