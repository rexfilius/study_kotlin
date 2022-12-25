package assignment.taxipark

fun TaxiPark.findFakeDrivers1(): Set<Driver> =
        allDrivers.filter { d -> trips.none { it.driver == d } }.toSet()

fun TaxiPark.findFakeDrivers2(): Set<Driver> =
        allDrivers - (trips.map { it.driver })