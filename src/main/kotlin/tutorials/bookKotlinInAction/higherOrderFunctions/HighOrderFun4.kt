package higherOrderFunctions

/**
 * Function types and lambda expressions together constitute a great tool to create
 * reusable code. Many kinds of code duplication that previously could be avoided only
 * through cumbersome constructions can now be eliminated
 * by using succinct lambda expressions.
 */
enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

data class SiteVisit(val path: String, val duration: Double, val os: OS)

fun List<SiteVisit>.averageDurationFor(os: OS) =
    filter { it.os == os }.map(SiteVisit::duration).average()

fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
    filter(predicate).map(SiteVisit::duration).average()

fun main() {
    val log = listOf(
        SiteVisit("/", 34.0, OS.WINDOWS),
        SiteVisit("/", 22.0, OS.MAC),
        SiteVisit("/login", 12.0, OS.WINDOWS),
        SiteVisit("/signup", 8.0, OS.IOS),
        SiteVisit("/", 16.3, OS.ANDROID)
    )

    /**
     * Imagine that you need to display the average duration of visits from Windows
     * machines. You can perform the task using the average function.
     */
    val averageWindowsDuration =
        log.filter { it.os == OS.WINDOWS }
            .map(SiteVisit::duration)
            .average()
    println("Average windows duration: $averageWindowsDuration")

    // Removing duplication with a regular function
    println(log.averageDurationFor(OS.WINDOWS))
    println(log.averageDurationFor(OS.MAC))

    /**
     * A regular function is not powerful enough. Imagine that you're interested in
     * the average duration of visits from the mobile platforms
     * (currently you recognize two of them: iOS and Android).
     */
    val averageMobileDuration = log
        .filter { it.os in setOf(OS.IOS, OS.ANDROID) }
        .map(SiteVisit::duration)
        .average()
    println("Average mobile duration: $averageMobileDuration")

    // Removing duplication with a higher order function
    println(log.averageDurationFor {
        it.os in setOf(OS.ANDROID, OS.IOS)
    })
    println(log.averageDurationFor {
        it.os == OS.IOS && it.path == "/signup"
    })

    /**
     * Function types can help eliminate code duplication. If you're tempted to copy
     * and paste a piece of the code, it's likely that the duplication can be avoided.
     * With lambdas, you can extract not only the data that's repeated,
     * but the behavior as well.
     */
}