package collections

/**
 * A set is an unordered collection that does not support duplicates. For creating sets,
 * there are functions setOf() and mutableSetOf(). A read-only view of a mutable set can
 * be obtained by casting it to Set.
 */
val openIssues: MutableSet<String> =
    mutableSetOf("uniqueDesc1", "uniqueDesc2", "uniqueDesc3")

/**
 * Returns a boolean value showing if the element was actually added
 */
fun addIssue(uniqueDesc: String): Boolean = openIssues.add(uniqueDesc)

/**
 * Returns a string, based on function input parameter.
 */
fun getStatusLog(isAdded: Boolean): String =
    if (isAdded) "registered correctly." else "marked as duplicate and rejected."

fun main() {

    val aNewIssue = "uniqueDesc4"
    val anIssueAlreadyIn = "uniqueDesc2"

    println("Issue $aNewIssue ${getStatusLog(addIssue(aNewIssue))}")
    println("Issue $anIssueAlreadyIn ${getStatusLog(addIssue(anIssueAlreadyIn))}")

}
