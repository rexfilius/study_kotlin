package documentation.typeSystem

// The 'is' operator checks if an expression is an instance of a type.
// If an immutable local variable or property is checked for a specific type,
// there's no need to cast it explicitly

fun main() {

    val value: Any = "String"

}

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // 'obj' is automatically cast to 'String' in this branch
        return obj.length
    }

    // 'obj' is still of type 'Any' outside the type-checked branch
    return null
}

fun getStringLength2(obj: Any): Int? {
    if (obj !is String) return null

    // 'obj' is automatically cast to `String` in this branch
    return obj.length
}

fun getStringLength3(obj: Any): Int? {
    // `obj` is automatically cast to `String` on the right-hand side of `&&`
    if (obj is String && obj.length > 0) {
        return obj.length
    }
    return null
}


