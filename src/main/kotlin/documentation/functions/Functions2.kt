package documentation.functions

/**
 * When calling a function, you can name one or more of its arguments. This may be helpful
 * when a function has a large number of arguments, and it's difficult to associate
 * a value with an argument, especially if it's a boolean or null value. When you use
 * named arguments in a function call, you can freely change the order they are listed in,
 * and if you want to use their default values you can just leave them out altogether
 */
fun reformat(
    str: String,
    normalizeCase: Boolean = true,
    upperCaseFirstLetter: Boolean = true,
    divideByCamelHumps: Boolean = false,
    wordSeparator: Char = ' '
) {
}

// when calling 'reformat' function, you don't have to name all its arguments
val v = reformat(
    "String",
    false,
    upperCaseFirstLetter = false,
    divideByCamelHumps = true,
    '_'
)

/**
 * you can skip all arguments in 'reformat' with default values. You can also skip some
 * arguments with default values. However, after the first skipped arguments, you must
 * name all subsequent arguments
 */
val vv = reformat("This is a long String!")
val vvv = reformat(
    "This is a short string!",
    upperCaseFirstLetter = false,
    wordSeparator = '+'
)

// You can pass a variable number of arguments(vararg) with names using the spread operator
fun foodName(vararg foods: String) {}

val ff = foodName(foods = arrayOf("Rice", "Yam", "Egg"))
//val gg = foodName(foods = *arrayOf("Rice", "Yam", "Egg"))// redundant spread operator

/**
 * On the JVM: You can't use the named argument syntax when calling Java functions because
 * Java bytecode does not always preserve names of function parameters
 */