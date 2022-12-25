package basics

fun main() {

    // if-not-null shorthand
//    val firstName = readLine()
//    val lastName = readLine()
//    val nameList = listOf(firstName, lastName)
//    println(nameList?.size)     // size is printed if files is not null

//    // if-not-null-else shorthand
//    println(nameList?.size ?: "empty")      // if files is null, this prints "empty"

    // Execute a statement if null
    // ...

    // Get first item of a possibly empty collection
    val names = listOf("")
    val firstName = names.firstOrNull() ?: "no-first-name-on-list"
    println(firstName)

    // Execute if not null
    val value = ""
    value?.let {
        //...execute this block if not null
    }

    // Map nullable value if not null
    // ...

}