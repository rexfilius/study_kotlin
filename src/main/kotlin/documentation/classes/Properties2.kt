package documentation.classes

// TODO: Read more on Backing Fields and Backing Properties

/**
 * In Kotlin, a field is only used as a part of a property to hold its value in memory.
 * Fields can not be declared directly. However, when a property needs a backing field,
 * Kotlin provides it automatically. This backing field can be referenced in
 * the accessors using the field identifier
 */
var counter = 0
    set(value) {
        if (value >= 0) field = value
    }

/**
 * A backing field will be generated for a property if it uses the default
 * implementation of at least one of the accessors, or if a custom accessor
 * references it through the field identifier.
 * in the code below there will be no backing field
 */
val isAString: String
    get() = "name".capitalize()

/**
 * If you want to do something that does not fit into this implicit backing field scheme,
 * you can always fall back to having a backing property
 */
private var _table: Map<String, Int>? = null
public val table: Map<String, Int>
    get() {
        if (_table == null) {
            _table = HashMap() // Type parameters are inferred
        }
        return _table ?: throw AssertionError("Set to null by another thread")
    }

/**
 * NOTE: On JVM, access to private properties with default getters and setters
 * is optimized to avoid function call overhead
 */

fun main() {
    println(counter)
}