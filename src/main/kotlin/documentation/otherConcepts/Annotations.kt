package otherConcepts

/**
 * Annotations are means of attaching metadata to code.
 * To declare an annotation, put the 'annotation' modifier in front of a class.
 * Additional attributes of the annotation can be specified by annotating the
 * annotation class with meta-annotations.
 * ...
 * @Target specifies the possible kinds of elements which can be annotated with
 * the annotation (such as classes, functions, properties, and expressions)
 * ...
 * @Retention specifies whether the annotation is stored in the compiled class files
 * and whether it's visible through reflection at runtime (by default, both are true);
 * ...
 * @Repeatable allows using the same annotation on a single element multiple times
 * ...
 * @MustBeDocumented specifies that the annotation is part of the public API and should be
 * included in the class or method signature shown in the generated API documentation
 */

@Target(
        AnnotationTarget.CLASS,
        AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER,
        AnnotationTarget.EXPRESSION,
        AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Fancy

// Usage of @Fancy annotation
@Fancy
class Foo {
    @Fancy
    fun baz(@Fancy foo: Int): Int {
        return (@Fancy 1)
    }
}

// If you need to annotate the primary constructor of a class, you need to add the
// constructor keyword to the constructor declaration, and add the annotations before it
// ...
// class Foo @Inject constructor(dependency: MyDependency) {/**/ }

// You can also annotate property accessors
class Foo2 {
    var x: Foo? = null
        @Fancy set
}

