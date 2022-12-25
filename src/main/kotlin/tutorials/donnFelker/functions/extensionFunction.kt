package functions

fun main() {

    val name = "Donn Felker"
    //println(name.models.initials())

    val age = 35
    println(age.isAdult())

    val person = PersonJ("Donn", "Felker", 43)
    println(person.fullName())
}

class PersonJ(val firstName: String, val lastName: String, val age: Int)

/* an Extension Function */
/*fun String.models.initials(): String {
    val values = this.split(' ')
    val firstInitial = values[0].substring(0, 1)
    val lastInitial = values[1].substring(0,1)
    return "$firstInitial$lastInitial"
}*/

/* an Extension Function */
fun Int.isAdult(): Boolean = this >= 18

/* an Extension Function */
fun PersonJ.fullName() = "${this.firstName} ${this.lastName}"