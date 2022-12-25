package collections

import classes.User

fun main() {

    /* Arrays */
    /*val items = arrayOf(1, 2, 3, 4, 5, "Kel")
    val integers = intArrayOf(3, 57, 35)
    val doubleNumbers = doubleArrayOf(1.3, 4.3, 2.4)
    items.forEach { println(it) }

    val users = arrayOf(
        User("Donn", "Felker"),
        User("Jane", "Doe")
    )
    users.forEach { println(it) }

    // adding to an array
    val updatedUsers = users.plus(User("John", "Wick"))
    updatedUsers.forEach { println(it) }*/

    /* List */
    val list = listOf(1, 2, 3, 4, 5) // read-only/immutable list
    list.forEach { println(it) }

    val names = listOf(
        User("Joe", "Rogan"),
        User("James", "Kel")
    )
    names.forEach { println(it) }

    val first = names.first()
    println(first)

    // Empty List
    val name: String? = null
    val stuff = if (name == null) emptyList() else listOf(name)
    println("--------------------------------------------------")

    // Mutable List
    val things = mutableListOf("James", 1, true)
    val number = mutableListOf(1, 34, 45)

    things.forEach { println(it) }
    number.forEach { println(it) }
    println("-------------------------------------------")
    number.add(3)
    number.forEach { println(it) }
    println("-------------------------------------------")

    // Filtering a List
    val guys = listOf("James", "Femi", "John", "Bob", "Jasper", "Temi")
    val filtered = guys.filter { it.endsWith('i') } // you can do a lot with "it"
    println(filtered)
    println("---------------------------------------------")

    val ages = listOf(23, 33, 12, 9, 17, 19, 99)
    val adults = ages.filter(::isAdult)
    println(adults)
    println("-----------------------------------------------")

    val n = listOf("Donn", "Bob", "Jane", "Jenny", "Tushar", "Kavita", "Donovan")
    val r = n.filterNot { it.contains("a") }
    println(r)
    println("----------------------------------------------------")

    // Finding items in a list
    val city = listOf("Lagos", "Accra", "Cape Town", "Nairobi", "Lome")
    val result = city.find { it == "Lome" } // 'find' returns 'null' if item isn't found
    println(result)
    println("-----------------------------------------------------")

    // Creating a List from an Existing List
    val approved = mutableListOf("Daniele", "Paul")
    val approvedName = listOf("Donn", "Bob", "Jane", "Jenny", "Tushar", "Kavita", "Donovan")
    approvedName.filterTo(approved, { it.contains("a") })
    println(approved)
    println("---------------------------------------------------------")


}

fun isAdult(value: Int): Boolean {
    return value >= 18
}