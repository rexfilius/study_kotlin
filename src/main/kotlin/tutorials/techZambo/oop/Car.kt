package oop

fun main() {
    var car = Car()
    println("car name is ${car.carName}")
    println("car noise is ${car.makeNoise()}")
    println("car vin number is ${car.showVinNumber()}")
}

class Car: Vehicle() {
    var carName = "Toyota"
    private val vinNumber = 19389

    fun showVinNumber(): Int {
        return vinNumber
    }
}

open class Vehicle: Machine() {
    fun makeNoise(): String {
        return "vrruumm"
    }
}

class Tractor: Vehicle() {
    fun roamAroundCrops() {
        // todo
    }
}

open class Machine {
    fun doStuff() {
        //
    }
}