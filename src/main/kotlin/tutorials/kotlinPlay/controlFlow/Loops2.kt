package controlFlow

class Animal(val name: String)

class Zoo(val animals: List<Animal>) {

    /**
     * Defines an iterator in a class. It must be named iterator and have the operator
     * modifier. This function returns the iterator that meets the following method
     * requirements: next(): Animal -> hasNext(): Boolean
     */
    operator fun iterator(): Iterator<Animal> {
        return animals.iterator()
    }
}

fun main() {

    val zoo = Zoo(
        listOf(
            Animal("zebra"), Animal("lion")
        )
    )

    for (animal in zoo) {
        println("Watch out, it's a ${animal.name}")
    }

}