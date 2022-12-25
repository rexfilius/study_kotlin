package generics

/**
 * - Type parameters of inline functions can be reified, which means you can refer
 * to actual type arguments at runtime.
 * - If you mark a function with the inline keyword, the compiler will replace every
 * call to the function with the actual code implementing the function. Making the
 * function inline may improve performance if this function uses lambdas as arguments:
 * the lambda code can be inlined as well, so no anonymous class will be created.
 * - Inline function with reified type parameters cannot be called from Java code.
 * Normal inline functions are accessible to Java as regular functions - they can be
 * called but are not inlined. Functions with reified type parameters require additional
 * processing to substitute the type argument values into the bytecode, and therefore
 * they must always be inlined. This makes it impossible to call them in a regular way,
 * as the Java code does.
 * - An inline function can have multiple reified type parameters, and it can have
 * non-reified type parameters in addition to the reified ones.
 */
fun main() {

    println(isA<String>("abc"))    // true
    println(isA<String>(123))    // false

    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>())    // [one, three]

}

inline fun <reified T> isA(value: Any) = value is T

// ANDROID CODE:: Instead of passing the class of the activity as a
// java.lang.Class, you can also use a reified type parameter:
/*
inline fun <reified T : Activity> Context.startActivity() {
val intent = Intent(this, T::class.java)
startActivity(intent)
}
startActivity<DetailActivity>()
*/