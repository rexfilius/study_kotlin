package assignment.taxipark

fun TaxiPark.checkParetoPrinciple(): Boolean {
    if (trips.isEmpty()) return false

    val totalIncome = trips.sumByDouble(Trip::cost)

    val sortedDriversIncome: List<Double> = trips
                    .groupBy(Trip::driver)
                    .map { (_, tripsByDriver) -> tripsByDriver.sumByDouble(Trip::cost) }
                    .sortedDescending()

    val numberOfTopDrivers = (0.2 * allDrivers.size).toInt()

    val incomeTopDrivers = sortedDriversIncome
            .take(numberOfTopDrivers)
            .sum()

    return incomeTopDrivers >= 0.8 * totalIncome
}