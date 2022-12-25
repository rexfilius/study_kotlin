package generics

/**
 * - If you declare a generic class or function, any type arguments, including nullable
 * ones, can be substituted for its type parameters. In effect, a type parameter with
 * no upper bound specified will have the upper bound of Any?.
 * - In the process function, the parameter value is nullable, even though T isn’t
 * marked with a question mark. This is the case because specific instantiations of
 * the Processor class can use a nullable type for T
 */
class Processor<T> {
    fun process(value: T) = value?.hashCode()
}

/**
 * - If you want to guarantee that a non-null type will always be substituted for a type
 * parameter, you can achieve this by specifying a constraint. If you don’t have any
 * restrictions other than nullability, you can use Any as the upper bound, replacing
 * the default Any?
 * - Note that you can make a type parameter non-null by specifying any non-null type
as an upper bound, not only the type Any.*/
class Processor2<T : Any> {
    fun process(value: T) = value.hashCode()
}

fun main() {

    val nullableStringProcessor = Processor<String?>()
    println(nullableStringProcessor.process(null))

    val nullableStringProcessor2 = Processor2<String>()
    println(nullableStringProcessor2.process("Jaden"))

}