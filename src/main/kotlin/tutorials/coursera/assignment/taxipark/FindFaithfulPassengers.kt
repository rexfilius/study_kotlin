package assignment.taxipark

fun TaxiPark.findFaithfulPassengers1(minTrips: Int): Set<Passenger> =
        trips
                .flatMap(Trip::passengers)  // lambda converted to reference
                .groupBy { passenger -> passenger }
                .filterValues { group -> group.size >= minTrips }
                .keys

fun TaxiPark.findFaithfulPassengers2(minTrips: Int): Set<Passenger> =
        allPassengers
                .filter { p ->
                    trips.count { p in it.passengers } >= minTrips
                }
                .toSet()
