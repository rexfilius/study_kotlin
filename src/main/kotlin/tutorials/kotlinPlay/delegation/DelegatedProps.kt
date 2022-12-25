package delegation

import newLine
import kotlin.reflect.KProperty

/**
 * Kotlin provides a mechanism of delegated properties that allows delegating the calls
 * of the property set and get methods to a certain object. The delegate object in this
 * case should have the method getValue. For mutable properties,
 * you'll also need setValue.
 * - Delegation methods: The signatures of these methods are always as shown in the
 * example below. Implementations may contain any steps you need.
 * For immutable properties only getValue is required.
 */
class Delegate() {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${prop.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        println("$value has been assigned to ${prop.name} in $thisRef")
    }
}

/**
 * Delegates property p of type String to the instance of class Delegate. The delegate
 * object is defined after the by keyword.
 */
class Example {
    var p: String by Delegate()

    override fun toString() = "Example Class"
}

/**
 * The Kotlin standard library contains a bunch of useful delegates, like 'lazy',
 * 'observable' etc. You may use them as is. e.g. 'lazy' is used for lazy initialization.
 * If you want thread safety, use blockingLazy() instead: it guarantees that the values
 * will be computed only in one thread and that all threads will see the same value.
 */
class LazySample {
    init {
        println("created!")
    }

    val lazyStr: String by lazy {
        println("computed!")
        "my lazy"
    }
}

/**
 * Property delegation can be used for storing properties in a map. This is handy for
 * tasks like parsing JSON or doing other "dynamic" stuff. You can delegate mutable
 * properties to a map as well. In this case, the map will be modified upon property
 * assignments. Note that you will need MutableMap instead of read-only Map.
 */
class UserJ(val map: Map<String, Any?>) {
    // Delegates take values from the map by the string keys - names of properties.
    val name: String by map
    val age: Int by map
}

fun main() {

    val e = Example()
    println(e.p)
    e.p = "NEW"
    "" newLine ""

    // Property lazy is not initialized on object creation.
    val sample = LazySample()
    // The first call to get() executes the lambda expression passed to lazy() as an
    // argument and saves the result.
    println("lazyStr = ${sample.lazyStr}")
    // Further calls to get() return the saved result.
    println(" = ${sample.lazyStr}")
    "" newLine ""

    val user = UserJ(
        mapOf(
            "name" to "John Doe",
            "age" to 25
        )
    )
    println("name = ${user.name}, age = ${user.age}")

}