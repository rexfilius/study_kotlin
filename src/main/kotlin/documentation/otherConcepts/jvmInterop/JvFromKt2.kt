package documentation.otherConcepts.jvmInterop

fun main() {

    /**
     * Any reference in Java may be null, which makes Kotlin's requirements of strict
     * null-safety impractical for objects coming from Java. Types of Java declarations are
     * treated in Kotlin in a specific manner and called platform types. Null-checks are
     * relaxed for such types, so that safety guarantees for them are the same as in Java
     * ...
     * When you call methods on variables of platform types, Kotlin doesn't issue nullability
     * errors at compile time, but the call may fail at runtime, because of a null-pointer
     * exception or an assertion that Kotlin generates to prevent nulls from propagating
     */
    val list = ArrayList<String>() // non-null (constructor result)
    list.add("Item")
    val size = list.size // non-null (primitive int)
    val item = list[0] // platform type inferred (ordinary Java object)
    item.substring(1) // allowed, may throw an exception if item == null

    /**
     * Platform types are non-denotable, meaning that you can't write them down explicitly
     * in the language. When a platform value is assigned to a Kotlin variable, you can
     * rely on the type inference (the variable will have an inferred platform type then,
     * as item has in the example above), or you can choose the type you expect (both
     * nullable and non-null types are allowed)
     */
    val nullable: String? = item // allowed, always works
    val notNull: String = item // allowed, may fail at runtime
}

/**
 * Platform types can't be mentioned explicitly in the program, so there's no syntax for
 * them in the language. Nevertheless, the compiler and IDE need to display them sometimes
 * (e.g in error messages or parameter info), so there is a mnemonic notation for them:
 * 1) T! means "T or T? ",
 * 2) (Mutable)Collection<T>! means "Java collection of T may be mutable or not,
 *    may be nullable or not",
 * 3) Array<(out) T>! means "Java array of T (or a subtype of T ), nullable or not
 * ...
 * Java types that have nullability annotations are represented not as platform types,
 * but as actual nullable or non-null Kotlin types. The compiler supports several flavors
 * of nullability annotations.
 */