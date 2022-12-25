package productivityBoosters

import java.time.LocalDate
import java.time.chrono.ChronoLocalDate

/**
 * The Kotlin compiler is smart enough to perform type casts automatically in most cases, including:
 * - Casts from nullable types to their non-nullable counterparts.
 * - Casts from a supertype to a subtype.
 */
fun main() {

    // Declares a nullable variable.
    val date: ChronoLocalDate? = LocalDate.now()

    // Smart-cast to non-nullable (thus allowing direct access to isLeapYear).
    if (date != null) println(date.isLeapYear)

    // Smart-cast inside a condition (like Java, Kotlin uses short-circuiting).
    if (date != null && date.isLeapYear) println("It is a leap year")

    // Smart-cast inside a condition (also enabled by short-circuiting).
    if (date == null || date.isLeapYear) println("Noe February 29 this year")

    // Smart-cast to the subtype LocalDate.
    if (date is LocalDate) {
        val month = date.monthValue
        println(month)
    }

}