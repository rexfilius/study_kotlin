package documentation.generics

/**
 * STAR PROJECTIONS
 * - Sometimes you want to say that you know nothing about the type argument, but still
 * want to use it in a safe way. The safe way here is to define such a projection of the
 * generic type, that every concrete instantiation of that generic type would be a
 * subtype of that projection. Kotlin provides so called star-projection syntax for this:
 *
 * - For Foo<out T : TUpper>, where T is a covariant type parameter with the upper bound
 * TUpper, Foo<*> is equivalent to Foo<out TUpper>. It means that when the T is unknown
 * you can safely read values of TUpper from Foo<*>.
 *
 * - For Foo<in T>, where T is a contravariant type parameter, Foo<*> is equivalent to
 * Foo<in Nothing>. It means there is nothing you can write to Foo<*> in a safe way when
 * T is unknown.
 *
 * - For Foo<T : TUpper>, where T is an invariant type parameter with the upper bound
 * TUpper, Foo<*> is equivalent to Foo<out TUpper> for reading values and to
 * Foo<in Nothing> for writing values.
 *
 * - If a generic type has several type parameters each of them can be projected
 * independently. For example, if the type is declared as
 * interface Function<in T, out U> you can imagine the following star-projections:
 *
 * - Function<*, String> means Function<in Nothing, String>
 * - Function<Int, *> means Function<Int, out Any?>
 * - Function<*, *> means Function<in Nothing, out Any?>
 *
 * - Star-projections are very much like Java's raw types, but safe.
 */
