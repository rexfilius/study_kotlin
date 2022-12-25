package productivityBoosters

/**
 * As with most other programming languages (Java, C++, etc.), Kotlin supports passing
 * arguments to methods and constructors according to the order they are defined. Kotlin
 * also supports named arguments to allow clearer invocations and avoid mistakes with the
 * order of arguments. Such mistakes are hard to find because they are not detected by
 * the compiler, e.g. when two sequential arguments have the same type.
 */
fun format(userName: String, domain: String): String {
    return "$userName@$domain"
}

fun main() {
    println(format("mario", "example.com"))
    println(format("domain.com", "username"))
    println(format(userName = "foo", domain = "bar.com"))
    println(format(domain = "frog.com", userName = "pepe"))
}