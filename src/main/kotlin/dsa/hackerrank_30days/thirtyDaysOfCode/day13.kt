package thirtyDaysOfCode

abstract class BookT(open val title: String, open val author: String) {
    abstract fun display()
}

class MyBook(
    override val title: String,
    override val author: String,
    private val price: Int
) : BookT(title, author) {

    override fun display() {
        println("Title: $title")
        println("Author: $author")
        println("Price: $price")
    }

}

fun main() {
    val title = readln()
    val author = readln()
    val price = readln().toInt()

    val newNovel = MyBook(title, author, price)
    newNovel.display()
}