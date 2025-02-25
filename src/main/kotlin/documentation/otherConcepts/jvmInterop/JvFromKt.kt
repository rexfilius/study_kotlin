package documentation.otherConcepts.jvmInterop

import java.util.*

fun demo(source: List<Int>) {
    val list = ArrayList<Int>()
    // for loops work for Java collections:
    for (item in source) {
        list.add(item)
    }
    // Operator conventions work as well:
    for (i in 0 until source.size - 1) {
        list[i] = source[i]    // get and set are called
    }
}

fun calendarDemo() {
    val calendar = Calendar.getInstance()
    if (calendar.firstDayOfWeek == Calendar.SUNDAY) { // call getFirstDayOfWeek()
        calendar.firstDayOfWeek = Calendar.MONDAY    // call setFirstDayOfWeek()
    }
    if (!calendar.isLenient) {    // call isLenient()
        calendar.isLenient = true  // call setLenient()
    }
}

/**
 * Note that, if the Java class only has a setter, it isn't visible as a property in
 * Kotlin because Kotlin doesn't support set-only properties
 * ...
 * If a Java method returns void, it will return Unit when called from Kotlin. If by any
 * chance someone uses that return value, it will be assigned at the call site by the
 * Kotlin compiler since the value itself is known in advance (being Unit ).
 */

/**
 * Some of the Kotlin keywords are valid identifiers in Java: in, object, is,
 * and other. If a Java library uses a Kotlin keyword for a method, you can still call
 * the method escaping it with the backtick (`) character:
 * ...e.g.
 *     foo.`is`(bar)
 */