package collections

fun main() {

    /* immutable map
    * in a map KEYS are unique */
    /*val states = mapOf(
        "NY" to "New York",
        "NJ" to "New Jersey",
        "CA" to "California"
    )

    val result = states["NY"]   // or 'states.get()'
    println(result)
    println("----------------------------------------------------------------")*/

    /* mutable map */
    /*val items = mutableMapOf(
        "LAG" to "Lagos",
        "IBD" to "Ibadan",
        "ABK" to "Abeokuta"
    )

    items["PHC"] = "Port Harcourt"   // or 'items.put("PHC", "Port Harcourt")'
    println(items)*/

    /*val state = mapOf(
        "NY" to "New York",
        "NJ" to "New Jersey",
        "NM" to "New Mexico",
        "CA" to "California",
        "TX" to "Texas",
        "WA" to "Washington",
        "OR" to "Oregon",
        "NV" to "Nevada",
        "CT" to "Connecticut",
        "FL" to "Florida",
        "AZ" to "Arizona",
        "MN" to "Minnesota",
        "NE" to "Nebraska"
    )

    val result = state.filter { it.key == "NY" }
    println(result)
    println("------------------------------------------------------------")

    val t = state.map(::findValueInWebService)
    println(t)
    val s = state.mapNotNull(::findValueInWebService)
    println(s)
    println("--------------------------------------------------------------")*/
}

fun findValueInWebService(entry: Map.Entry<String, String>): Map.Entry<String, String>? {
    if (entry.key.startsWith("N"))
        return null
    else
        return entry
}