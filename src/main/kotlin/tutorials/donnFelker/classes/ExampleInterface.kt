package classes

interface Mammal {
    var hasHands: Boolean
    fun walk()
}

interface Cow: Mammal {
    fun moo() = println("Moooooo")
}

interface HumanBeing: Mammal {
    fun speak()
}

class SpottedCow(override var hasHands: Boolean = false): Cow {

    override fun walk() = println("Walking on 4 legs")

}

class SmartCow(override var hasHands: Boolean): Cow {

    override fun walk() = println("riding a skateboard")

    override fun moo() = println("Moo mooo mooo")
}

/* Interface in Kotlin */
interface Discountable {
    fun discountPercent(): Double
}

class DigitalProduct: Discountable {
    override fun discountPercent(): Double {
        TODO("Not yet implemented")
    }
}

class GenericToy: Discountable {
    override fun discountPercent(): Double {
        TODO("Not yet implemented")
    }
}