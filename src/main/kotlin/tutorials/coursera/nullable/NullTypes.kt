package nullable

fun main() {
    val s1 = "always not null"
    val s2: String? = null
    val s3: String? = "can be null or not-null"

    println(s1.length)
    println(s2?.length) // safe call
    println(s3!!.length)    // not-null assertion: throwing NPE if s is null
    println()

    /* coping with Nullabilty -
    * use safe operator - ?.
    * use Elvis operator - ?:
    * use explicit checks - if-block
    * use less of not-null assertion - !! */

    val a: Int? = null
    val b: Int? = 1
    val c = 2
    val s4 = (a ?: 0) + c
    val s5 = (b ?: 0) + c
    println("$s4$s5")   // s4 is 2, s5 is 3
    println()

    // operator precedence on nullable type
    val x: Int? = 1
    val y = 2
    val a1 = x ?: 0 + y     // ans is 1
    val a2 = x ?: (0 + y)   // ans is 1
    val a3 = (x ?: 0) + y   // ans is 3
    println("$a1,$a2,$a3")  // ans would be different if x had a value of "null"

}