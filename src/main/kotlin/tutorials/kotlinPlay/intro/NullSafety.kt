package intro

/**
 * In an effort to rid the world of NullPointerException, variable types in Kotlin don't
 * allow the assignment of null. If you need a variable that can be null,
 * declare it nullable by adding '?' at the end of its type.
 */
fun main() {

    /**
     * Declares a non-null String variable. When trying to assign null to a non-nullable
     * variable, a compilation error is produced.
     */
    var neverNull: String = "This cannot be null"
    //neverNull = null

    /**
     * Declares a nullable String variable. Sets the null value to the nullable
     * variable - this is OK.
     */
    var nullable: String? = "You can keep a null here"
    nullable = null

    /**
     * When inferring types, the compiler assumes non-null for variables that are
     * initialized with a value. When trying to assign null to a variable with inferred
     * type, a compilation error is produced.
     */
    var inferredNonNull = "The compiler assumes non-null"
    //inferredNonNull = null

    /**
     * When passing a nullable argument to a function with non-null parameter,
     * a compilation error is produced
     */
    strLength(neverNull)
    //strLength(nullable)

}

/**
 * Sometimes Kotlin programs need to work with null values, such as when interacting with
 * external Java code or representing a truly absent state. Kotlin provides null tracking
 * to elegantly deal with such situations.
 * ...
 * [describeString] takes in a nullable string and returns its description. If the given
 * string is not null and not empty, return information about its length; otherwise,
 * tell the caller that the string is empty or null
 */
fun describeString(maybeString: String?): String {
    return if (maybeString != null && maybeString.isNotEmpty()) {
        "String of length ${maybeString.length}"
    } else {
        "Empty or null string"
    }
}

fun strLength(notNull: String): Int {
    return notNull.length
}