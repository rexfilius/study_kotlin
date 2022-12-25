package scopeFunctions

/**
 * apply executes a block of code on an object and returns the object itself. Inside the
 * block, the object is referenced by this. This function is handy for
 * initializing objects.
 */
fun main() {

    val person = MaleHuman()
    val stringDescription = person.apply {
        this.name = "Jake"
        this.age = 26
        this.about = "Android Developer"
    }
    println(stringDescription)
}

class MaleHuman {
    var name: String = ""
    var age: Int = 0
    var about: String = ""

}