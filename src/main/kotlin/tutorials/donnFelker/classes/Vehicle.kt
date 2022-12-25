package classes

/* abstract classes cannot be instantiated */
abstract class Vehicle3(var color: String, val numberOfWheels: Int, numberOfDoors: Int) {

    abstract fun drive()

    fun openDoor() {}

    fun turnOffIgnition() {}
}

abstract class TwoDoorCar(color: String, numberOfWheels: Int) :
    Vehicle3(color, numberOfWheels, 2) {

    abstract fun driveFast()
}

class HatchBackCar(color: String, numberOfWheels: Int, numberOfDoors: Int) :
    Vehicle3(color, numberOfWheels, numberOfDoors) {

    override fun drive() { }

}


/* internal modifier makes it available only in the module*/
internal class Axle(val numberOfWheels: Int) {

}

open class Vehicle2(var color: String) {

    private lateinit var axles: MutableList<Axle>

    fun info() = println("The vehicle is $color")

    fun addAxle(numberOfWheels: Int) = axles.add(Axle(numberOfWheels))

}

class Truck(color: String) : Vehicle2(color) {
    init {
        //axles = arrayOf(Axle(2), Axle(4))
        addAxle(2)
        addAxle(4)
    }
}