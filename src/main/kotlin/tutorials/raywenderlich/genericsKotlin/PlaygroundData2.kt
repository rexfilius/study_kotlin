package tutorials.raywenderlich.genericsKotlin

/**
 * A Cage accepts a type that IS-A Animal.
 * Animal is the upper bound, and it is equivalent to the Java’s extends keyword
 */
class Cage<T : Animal>(var animal: T, val size: Double)

/**
 * - The 'out' keyword indicates that T is only going to be produced by the methods
 * of this class. Thus, it must only appear in out positions.
 * - For this reason, T is the return type of the function getContentType().
 * None of the other methods include T as an input argument either
 * - By making CovariantCage<Dog> extend from CovariantCage<Animal>, in run-time,
 * any valid type (Animal, Dog, Bird, etc.) will replace T, so type-safety is guaranteed.
 */
class CovariantCage<out T : Animal>(private val t: T?) {
    fun getId(): Int? = t?.id
    fun getName(): String? = t?.name
    fun getContentType(): T? = t?.let { t } ?: run { null }
    fun printAnimalInfo(): String = "Animal ${t?.id} is called ${t?.name}"
}

/**
 * - On the other hand, there is contravariance. 'in' indicates that class methods
 * will only consume a certain parameter T, not producing it at all
 * - Here, setContentType replaces getContentType from the previous snippet. Thus,
 * this class always consumes T. Therefore, the parameter T takes only in positions
 * in the class methods. This constraint leads to state, for example, that
 * ContravarianceCage<Animal> is a sub-type of ContravarianceCage<Bird>.
 */
class ContravariantCage<in T : Bird>(private var t: T?) {
    fun getId(): Int? = t?.id
    fun getName(): String? = t?.name
    fun setContentType(t: T) = this.t == t
    fun printAnimalInfo(): String = "Animal ${t?.id} is called ${t?.name}"
}

/**
 * - The other alternative that Kotlin offers is type projection, which is a
 * materialization of use-site variance. The idea behind this is indicating a variance
 * constraint at the precise moment in which you use a parameterized class,
 * not when you declare it.
 */
fun examine(cageItem: Cage<out Animal>) {
    val animal: Animal = cageItem.animal
    println(animal)
}

class CageX<out T : Animal>(val animal: T, val size: Double)

interface Repository<S : CageX<Animal>> {
    fun registerCage(cage: S): Unit
}

class AnimalRepository : Repository<CageX<Animal>> {
    override fun registerCage(cage: CageX<Animal>) {
        println("registering cage for: ${cage.animal.name}")
    }
}

/**
 * - Without using 'out' declaration-site variance on CageX, CageX'Bird' will give
 * a compile error
 * - This also brings a limitation to CageX, since it will never include a function
 * having T as an input argument
 * - As a rule of thumb, you should use 'out T' in classes and methods that will not
 * modify T, but produce or use it as an output type. Contrary, you should use 'in T'
 * in classes and methods that will consume T, i.e. using it as an input type.
 * Following this rule will buy you type-safety when establishing class hierarchy sub-typing.
 */
class BirdRepository : Repository<CageX<Bird>> {
    override fun registerCage(cage: CageX<Bird>) {
        println("registering cage for: ${cage.animal.name}")
    }
}
