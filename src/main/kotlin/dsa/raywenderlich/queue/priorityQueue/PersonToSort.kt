package raywenderlich.queue.priorityQueue

data class PersonToSort(
    val name: String,
    val age: Int,
    val isMilitary: Boolean
)

object MilitaryPersonComparator : Comparator<PersonToSort> {
    override fun compare(o1: PersonToSort, o2: PersonToSort): Int {
        return when {
            o1.isMilitary && !o2.isMilitary -> 1

            !o1.isMilitary && o2.isMilitary -> -1

            o1.isMilitary && o2.isMilitary -> o1.age.compareTo(o2.age)

            else -> 0
        }
    }
}