package assignment.nicestrings

/*fun String.isNice(): Boolean {

    val noBadSubString = setOf("ba", "be", "bu").none { this.contains(it) }

    val hasThreeVowels = count { it in "aeiou" } >= 3

    val hasDouble =zipWithNext().any { it.first == it.second }

    return listOf(noBadSubString,hasThreeVowels, hasDouble).count { it } >= 2
}*/

// Verbose Version
fun String.isNice(): Boolean {
    val noBadSubString = !contains("ba") && !contains("be") && !contains("bu")

    val hasThreeVowels = count {
        it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u'
    } >= 3

    var hasDouble = false
    if (length > 1) {
        var prevCh: Char? = null
        for (ch in this) {
            if (ch == prevCh)
                hasDouble = true
            prevCh = ch
        }
    }

    var conditions = 0
    if (noBadSubString) conditions++
    if (hasThreeVowels) conditions++
    if (hasDouble) conditions++

    if (conditions >= 2) return true
    return false
}