@file:JvmName("StringExtensions")
package models

/* an Extension Function */
fun String.initials(): String {
    val values = this.split(' ')
    val firstInitial = values[0].substring(0, 1)
    val lastInitial = values[1].substring(0,1)
    return "$firstInitial$lastInitial"
}