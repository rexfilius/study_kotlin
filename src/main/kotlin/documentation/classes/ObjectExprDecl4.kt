package documentation.classes

// An object declaration inside a class can be marked with the 'companion' keyword
class MyClass2 {
    companion object Factory {
        fun create(): MyClass2 = MyClass2()
    }
}

class MyClass3 {
    companion object {/**/ }
}

fun main() {

    // members of the companion object can be called using simply the class name
    // as the qualifier
    val instance = MyClass2.create()

    // the name of the companion object can be omitted, in which case the name
    // 'Companion' will be used
    val instanceSecond = MyClass3
}

/**
 * Note that, even though the members of companion objects look like static members in
 * other languages, at runtime those are still instance members of real objects, and can,
 * for example, implement interfaces. However, on the JVM you can have members of
 * companion objects generated as real static methods and fields, if you use
 * the @JvmStatic annotation
 */
interface Factory<T> {
    fun create(): T
}

class MyClass4 {
    companion object : Factory<MyClass4> {
        override fun create(): MyClass4 = MyClass4()
    }
}

val f: Factory<MyClass4> = MyClass4

/**
 * DIFFERENCE BETWEEN OBJECT EXPRESSIONS & DECLARATIONS
 * 1. Object expressions are executed (and initialized) immediately, where they are used
 * 2. Object declarations are initialized lazily, when accessed for the first time
 * 3. A companion object is initialized when the corresponding class is loaded(resolved)
 *    matching the semantics of a Java static initializer
 */
