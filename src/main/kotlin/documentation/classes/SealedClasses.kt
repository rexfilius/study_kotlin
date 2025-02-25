package documentation.classes

/**
 * Sealed classes represent restricted class hierarchies that provide more control over
 * inheritance. All subclasses of a sealed class are known at compile time. No other
 * subclasses may appear after a module with the sealed class is compiled
 * ...
 * In some sense, sealed classes are similar to enum classes: the set of values for an enum
 * type is also restricted, but each enum constant exists only as a single instance,
 * whereas a subclass of a sealed class can have multiple instances,
 * each with its own state
 * ...
 * A sealed class is abstract by itself, it can't be instantiated directly
 * and can have 'abstract' members.
 * Sealed class' can't have non-private constructors(they are private by default)
 */
sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()

/**
 * All direct subclasses of a sealed class must be declared in the same file as the sealed
 * class itself. Classes that extend direct subclasses of a sealed class
 * (indirect inheritors) can be placed anywhere, not necessarily in the same file
 * ...
 * enum classes can't extend a sealed class (as well as any other class),
 * but they can implement sealed interfaces
 */

/**
 * The key benefit of using sealed classes comes into play when you use them in a when
 * expression. If it's possible to verify that the statement covers all cases, you don't
 * need to add an else clause to the statement. However, this works only if you use when
 * as an expression (using the result) and not as a statement
 */
fun eval(expr: Expr): Double = when (expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
    // the 'else' isn't required because we've covered all cases
}