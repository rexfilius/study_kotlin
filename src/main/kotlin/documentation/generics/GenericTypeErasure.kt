package documentation.generics

/**
 * TYPE ERASURE
 * - The type safety checks that Kotlin performs for generic declaration usages are only
 * done at compile time. At runtime, the instances of generic types do not hold any
 * information about their actual type arguments. The type information is said to be
 * erased.
 * For example, the instances of Foo<Bar> and Foo<Baz?> are erased to just Foo<*>.
 *
 * - Therefore, there is no general way to check whether an instance of a generic type
 * was created with certain type arguments at runtime, and the compiler prohibits such
 * is -checks.
 *
 * - Type casts to generic types with concrete type arguments, for example,
 * foo as List<String>, cannot be checked at runtime.
 *
 * - These unchecked casts can be used when type safety is implied by the high-level
 * program logic but cannot be inferred directly by the compiler. The compiler issues
 * a warning on unchecked casts, and at runtime,
 * only the non-generic part is checked (equivalent to foo as List<*> ).
 *
 * - The type arguments of a generic function calls are also only checked at compile time.
 * Inside the function bodies, the type parameters cannot be used for type checks,
 * and type casts to type parameters (foo as T) are unchecked.
 *
 * - However, reified type parameters of inline functions are substituted by the actual
 * type arguments in the inlined function body at the call sites and thus can be used
 * for type checks and casts, with the same restrictions for instances of generic types
 */