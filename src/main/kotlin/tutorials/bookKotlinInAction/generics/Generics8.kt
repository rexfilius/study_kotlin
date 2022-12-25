package generics

/**
 * - A class that is contravariant on the type parameter is a generic class
 * (e.g. let’s consider Consumer-T) for which the following holds: Consumer-A is a
 * subtype of Consumer-B, if B is a subtype of A. The type arguments A and B changed
 * places, so we say the subtyping is reversed. e.g. Consumer-Animal is a subtype
 * of Consumer-Cat.
 * - The 'in' keyword means values of the corresponding type are passed in to methods
 * of this class and consumed by those methods. Similar to the covariant case,
 * constraining use of the type parameter leads to the specific subtyping relation.
 * The 'in' keyword on the type parameter T means the subtyping is reversed and T
 * can be used only in 'in' positions.
 */
interface ComparatorX<in T> {
    fun compare(e1: T, e2: T): Int {
        return e1.hashCode() - e2.hashCode()
    }
}

fun main() {

}

/**
 * - A class or interface can be covariant on one type parameter and contravariant on
 * another. The classic example is the Function interface.
 */
interface FunctionX<in P, out R> {
    operator fun invoke(p: P): R
}
