package collections

import newLine

/**
 * A list is an ordered collection of items. In Kotlin, lists can be either mutable
 * (MutableList) or read-only (List). For list creation, use the standard library
 * functions listOf() for read-only lists and mutableListOf() for mutable lists.
 * To prevent unwanted modifications, obtain read-only views of mutable lists
 * by casting them to List.
 * - [systemUsers] and [sudoers] creates a MutableList and a read-only view of the list.
 */
val systemUsers: MutableList<Int> = mutableListOf(1, 2, 3)
val sudoers: List<Int> = systemUsers

/**
 * Adds a new item to the MutableList
 */
fun addSystemUser(newUser: Int) = systemUsers.add(newUser)

/**
 * A function that returns an immutable List
 */
fun getSysSudoers(): List<Int> = sudoers

fun main() {

    /**
     * Updates the MutableList. All related read-only views are updated as well
     * since they point to the same object.
     */
    addSystemUser(4)

    // Retrieves the size of the read-only list.
    println("Tot sudoers: ${getSysSudoers().size}")

    // Iterates the list and prints its elements.
    getSysSudoers().forEach { i ->
        println("Some useful info on user $i")
    }
    "" newLine ""

    // Attempting to write to the read-only view causes a compilation error.
    // getSysSudoers().add(5)
}
