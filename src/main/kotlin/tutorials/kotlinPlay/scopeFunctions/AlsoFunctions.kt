package scopeFunctions

/**
 * also works like apply: it executes a given block and returns the object called.
 * Inside the block, the object is referenced by it, so it's easier to pass it as an
 * argument. This function is handy for embedding additional actions, such as
 * logging in call chains.
 */
fun main() {

    val john = Neighbour("John", 24, "Driver")
        .also {
            //
        }
}

data class Neighbour(val name: String, var age: Int, var about: String) {
    fun writeCreationLog(person: Neighbour) {
        println("A new neighbour ${person.name} has moved in")
    }
}