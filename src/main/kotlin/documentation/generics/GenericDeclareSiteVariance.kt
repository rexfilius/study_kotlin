package documentation.generics

/**
 * As in Java, classes in Kotlin can have type parameters. To create an instance of the
 * class, provide the type arguments. You can omit the type arguments if the parameters
 * may be inferred
 */
class Box<T>(t: T) {
    var value = t
}

fun main() {
    val box: Box<Int> = Box(1)
    val box2 = Box(1)
}

/**
 * - One of the most tricky parts of Java's type system is wildcard types. And Kotlin
 * doesn't have any. Instead, it has two other things:
 * Declaration-site variance & Type projections
 * - DECLARATION-SITE VARIANCE::
 * - The general rule is: when a type parameter T of a class C is declared 'out', it may
 * occur only in out-position in the members of C, but in return C<Base> can safely be a
 * supertype of C<Derived>.
 * - In other words, you can say that the class C is covariant in the parameter T, or
 * that T is a covariant type parameter. You can think of C as being a
 * producer of T's, and NOT a consumer of T's.
 * - The out modifier is called a variance annotation, and since it is provided at the
 * type parameter declaration site, it provides declaration-site variance. This is in
 * contrast with Java's use-site variance where wildcards in the type usages makes
 * the types covariant.
 * - In addition to 'out', Kotlin provides a complementary variance annotation: 'in'.
 * It makes a type parameter contravariant: it can only be consumed and never produced.
 * A good example of a contravariant type is 'Comparable' - the interface.
 * - For Declaration-Site Variance ->
 * - out T ... it can take a super type of T
 * - in T ... it can take a sub type of T
 */
interface Source<out T> {
    fun nextT(): T
}

fun justADemo(strings: Source<String>) {
    val objects: Source<Any> = strings
}

fun anotherDemo(integer: Source<Int>) {
    val number : Source<Number> = integer
}

interface ComparableX<in T> {
    operator fun compareTo(other: T): Int
}

fun demoCompare(x: ComparableX<Number>) {
    x.compareTo(1.0)
    // 1.0 has type Double, which is a subtype of Number
    // Thus, you can assign typeSystem.getX to a variable of type Comparable<Double>
    val y: ComparableX<Double> = x // OK!
}
