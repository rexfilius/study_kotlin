package raywenderlich.intro

fun main() {

    val mutablePlaces = mutableListOf("Paris", "London", "Bucharest")

    mutablePlaces.add("Budapest")
    println(mutablePlaces)    // [Paris, London, Bucharest, Budapest]

    mutablePlaces.add(0, "Kiev")
    println(mutablePlaces)    // [Kiev, Paris, London, Bucharest, Budapest]
    /**
     * [1] INSERTION LOCATION
     * Inserting "Budapest" using add() places the string at the end of the list.
     * This is a CONSTANT-TIME operation i.e. the time it takes to perform this
     * operation stays the same no matter how large the list becomes.
     * ...
     * However, there may come a time that you need to insert an element in a
     * particular location(e.g. middle of the list). To help illustrate, consider
     * the following analogy.
     * ...
     * You’re standing in line for the movies. Someone new comes along to join the
     * lineup. If they just go to the end of the line, nobody will even notice the
     * newcomer. But, if the newcomer tried to insert himself into the middle of the
     * line, he would have to convince half the lineup to shuffle back to make room.
     * And if he were terribly rude, he may try to insert himself at the raywenderlich.util.head of the
     * line. This is the worst case scenario because every single person in the lineup
     * would need to shuffle back to make room for this new person in front!
     * ...
     * This is exactly how lists work. Inserting new elements from anywhere aside from
     * the end will force elements to shift back to make room for the new element
     * ...
     * To be precise, every element must shift back by one index. If we consider the
     * number of items in the list to be n, this would take n steps. The time for
     * this operation grows as the number of elements in the list grows. If the number
     * of elements in the list doubles, the time required for this 'add'
     * operation will also double.
     * ...
     * If inserting elements in front of a collection is a common operation for your
     * program, you may want to consider a different data structure to hold your data.
     */

    /**
     * [2] CAPACITY
     * The second factor that determines the speed of insertion is the list's capacity.
     * Underneath the hood, Kotlin lists are allocated with a predetermined amount
     * of space for its elements. If you try to add new elements to a list that is
     * already at maximum capacity, the List must restructure itself to make more
     * room for more elements.
     * ...
     * This is done by copying all the current elements of the list in a new and
     * bigger container in memory. However, this comes at a cost. Each element of
     * the list has to be accessed and copied. This means that any insertion, even at
     * the end, could take n steps to complete if a copy is made.
     * ...
     * Note: Kotlin Standard Library employs a strategy that minimizes the times this
     * copying needs to occur. Each time it runs out of storage and needs to copy,
     * it doubles the capacity
     */
}