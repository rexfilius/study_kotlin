package genericsKotlin

fun main() {

    val dog1: Animal = Dog(id = 0, name = "Swift", furColor = FurColor.BLACK)
    val dog2: Dog = Dog(id = 1, name = "Stu", furColor = FurColor.PATCHED)
    val cat1: Animal = Cat(id = 3, name = "Tuno", eyesColor = EyesColor.GREEN)

    val animal: Animal = cat1


    val dogList: List<Dog> = listOf()
    // This assignation below is not valid in Java (not covariant)
    var animalList: List<Animal> = dogList

    val dogMutableList: MutableList<Dog> = mutableListOf()
    // This assignation below fails as in Java (invariant)
    //var animalMutableList: MutableList<Animal> = dogMutableList

    println("Done!")


    val dog: Dog = Dog(id = 1, name = "Stu", furColor = FurColor.PATCHED)
    val cat: Cat = Cat(id = 4, name = "Peter", eyesColor = EyesColor.GREEN)
    val cageDog1: Cage<Dog> = Cage(animal = dog, size = 6.0)
    val cageCat: Cage<Cat> = Cage(animal = cat, size = 3.0)

    /**
     * - Generally speaking, Variance defines Inheritance relationships of parameterized
     * types. Variance is all about sub-typing. Thus, we can say that Cage is invariant
     * in the parameter T.
     * - Note: Bear in mind that the error below only happens when attempting to write
     * or modify (assignation) Cage<Animal>.*/
    val cageAnimal: Cage<Animal>
    val cageDog: Cage<Dog> = Cage(animal = dog, size = 3.2)
    // cageAnimal = cageDog   // error condition

    val dogCovariant: Dog = Dog(id = 1, name = "Stucy", furColor = FurColor.PATCHED)
    val cage1: CovariantCage<Dog> = CovariantCage(dogCovariant)
    var cage2: CovariantCage<Animal> = cage1   // thanks to being 'out'

    /** type projection */
    val bird: Bird = Eagle(
        id = 7, name = "Piti",
        featherColor = FeatherColor.YELLOW, maxSpeed = 75.0f
    )
    val animal2: Animal = Dog(id = 1, name = "Stu", furColor = FurColor.PATCHED)
    val cage01: Cage<Animal> = Cage(animal = animal2, size = 3.1)
    val cage02: Cage<Bird> = Cage(animal = bird, size = 0.9)
    examine(cage01)
    examine(cage02)   // 'out' provides type-safety so that this statement is valid

    /** On Collections*/
    var list0: MutableList<Animal>
    val list1: MutableList<Dog> = mutableListOf(dog2)
    val list2: MutableList<out Animal> = mutableListOf(dog1, dog2)
    //list0 = list1   // the IDE reports an error
    list0 = list2 as MutableList<Animal>

}