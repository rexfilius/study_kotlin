package assignment.taxipark

fun TaxiPark.findSmartPassengers1(): Set<Passenger> {
    val (tripsWithDiscount, tripsWithoutDiscount) =
            trips.partition { it.discount != null }
    return allPassengers
            .filter { passenger ->
                tripsWithDiscount.count { passenger in it.passengers } >
                        tripsWithoutDiscount.count { passenger in it.passengers }
            }
            .toSet()
}

fun TaxiPark.findSmartPassengers2(): Set<Passenger> =
        allPassengers
                .associate { p ->
                    p to trips.filter { t -> p in t.passengers }
                }
                .filterValues { group ->
                    val(withDiscount, withoutDiscount) = group
                            .partition { it.discount != null }
                    withDiscount.size > withoutDiscount.size
                }
                .keys

fun TaxiPark.findSmartPassengers3(): Set<Passenger> =
        allPassengers.filter { p ->
            val withDiscount = trips.count { t -> p in t.passengers && t.discount != null }
            val withoutDiscount = trips.count { t -> p in t.passengers && t.discount == null }
            withDiscount > withoutDiscount
        }.toSet()