package functionalprogramming

data class Hero(
        val name: String,
        val age: Int,
        val gender: Gender?)

enum class Gender {MALE, FEMALE}

fun main() {
    val heroes = listOf(
            Hero("The Captain", 60, Gender.MALE),
            Hero("Frenchy", 42, Gender.MALE),
            Hero("The Kid", 9, null),
            Hero("Lady Lauren", 29, Gender.FEMALE),
            Hero("First Mate", 29, Gender.MALE),
            Hero("Sir Stephen", 37, Gender.MALE))

    println(heroes.last().name)  // ans = Sir Stephen
    println(heroes.firstOrNull { it.age == 30 }?.name)  // ans = null
    //println(heroes.first { it.age == 30 }.name) // NoSuchElementException is thrown
    println(heroes.map { it.age }.distinct().size)  // ans = 5
    println(heroes.filter { it.age < 30 }.size) // ans = 3
    println(heroes.maxBy { it.age }?.name)  // ans = The Captain
    println(heroes.all { it.age < 50 }) // ans = false
    println(heroes.any { it.gender == Gender.FEMALE })  // ans = true

    println()
    val(youngest, oldest) = heroes.partition { it.age < 30 }
    println("oldest is ${oldest.size}")
    println("youngest is ${youngest.size}")

    println()
    val mapByAge: Map<Int, List<Hero>> = heroes.groupBy { it.age }
    val(age, group) = mapByAge.maxBy { (_, group) -> group.size }!!
    println(age)
    println(group)

    println()
    val mapByName: Map<String, Hero> = heroes.associateBy { it.name }
    println(mapByName["Frenchy"]?.age)  // ans = 42
    println(mapByName.getValue("Frenchy").age)  // ans = 42, but can throw NoSuchElementExeception

    println()
    val mapByName2 = heroes.associate { it.name to it.age }
    println(mapByName2.getOrElse("Larry") {0})

    /*println()   // THIS IS BAD CODE
    val(first, second) =
            heroes.flatMap { heroes.map { hero -> it to hero } }
                    .maxBy { it.first.age - it.second.age }!!
    println(first.name)*/

    println()   // THIS IS GOOD CODE
    val allPossiblePairs = heroes.flatMap { first ->
                                            heroes.map { second -> first to second } }
    val(first, second) = allPossiblePairs.maxBy { it.first.age - it.second.age }!!
    println(first.name)

    // Simplifying Code
    // 1. do not use 'it' if it has different types in neighboring lines
    // 2. prefer explicit parameter names if it might be confusing otherwise
    // 3. learn the library and try to reuse the library functions as much as possible
}