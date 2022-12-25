fun getAnObject() {}

fun getAnyObject(): Any = getAnObject()

fun getAString(): String = ""

fun getAStringNull(): String? = null

fun String.getAStringNullExt(): String? = null

fun getAnInt(): Int = 2 * 3

fun getABooleanTrue(): Boolean = true

fun getABooleanFalse(): Boolean = false

fun getAChar(): Char = 'c'

infix fun String.newLine(s: String) = println(s)

const val itsNothing = ""

class AnObject() {}