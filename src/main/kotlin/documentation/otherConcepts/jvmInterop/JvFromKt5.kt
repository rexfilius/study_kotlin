package otherConcepts.jvmInterop

/**
 * OPERATORS
 * Since Java has no way of marking methods for which it makes sense to use the operator
 * syntax, Kotlin allows using any Java methods with the right name and signature as
 * operator overloads and other conventions (invoke() etc.) Calling Java methods using
 * the infix call syntax is not allowed
 */

/**
 * CHECKED EXCEPTIONS
 * In Kotlin, all exceptions are unchecked, meaning that the compiler does not force you
 * to catch any of them. So, when you call a Java method that declares a checked exception,
 * Kotlin does not force you to do anything
 */
fun render(list: List<*>, to: Appendable) {
    for (item in list) {
        to.append(item.toString()) // Java would require us to catch IOException here
    }
}

/**
 * OBJECT METHODS
 * When Java types are imported into Kotlin, all the references of the type
 * java.lang.Object are turned into Any. Since Any is not platform-specific, it only
 * declares toString(), hashCode() and equals() as its members, so to make other members
 * of java.lang.Object available, Kotlin uses extension functions
 */

/**
 * wait()/notify()
 * Methods wait() and notify() are not available on references of type Any. Their usage is
 * generally discouraged in favor of java.util.concurrent. If you really need to call
 * these methods, you can cast to java.lang.Object
 */
// (foo as java.lang.Object).wait()

/**
 * getClass()
 * To retrieve the Java class of an object, use the java extension property on a
 * class reference OR use the javaClass extension property
 */
// val fooClass = foo::class.java
// val fooClass = foo.javaClass

// clone()
// To override clone(), your class needs to extend kotlin.Cloneable:
class Example3: Cloneable {
    override fun clone(): Any {
        return super.clone()
    }
}

/**
 * finalize()
 * To override finalize(), all you need to do is simply declare it, without using the
 * override keyword. According to Java's rules, finalize() must not be private
 */
class C2 {
    protected fun finalize() {
        // code...
    }
}