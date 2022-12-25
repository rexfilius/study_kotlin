package collections

fun main() {

    /* Flatten a List or Array */
    val mine = listOf("Apples", "Grapes")
    val theirs = listOf("Oranges", "Pears", "Strawberries")
    val others = listOf("Kiwi", "Watermelon")
    val allOfUs = listOf(mine, theirs, others)

    println(allOfUs)
    println(allOfUs.flatten())
    println("-----------------------------------------------------")

    val mineArray = arrayOf("Apples", "Grapes")
    val theirsArray = arrayOf("Oranges", "Pears", "Strawberries")
    val othersArray = arrayOf("Kiwi", "Watermelon")
    val allArrays = arrayOf(mineArray, theirsArray, othersArray)

    println(allArrays.toString())
    println(allArrays.flatten())
    println("-------------------------------------------------------")

    /* Combining Immutable Lists */
    val one = listOf("Apples", "Grapes")
    val two = listOf("Oranges", "Pears", "Strawberries")
    val three = listOf("Kiwi", "Watermelon")

    val all = three.plus(one).plus(two)
    println(all)
    println(all.minus(one))
    println("---------------------------------------------------")

    /* Kotlin List Map Operator */
    val nameList = listOf(
        "Donn Felker", "Jane Doe", "Karthik Muhaj", "Peter Parker",
        "Clark Kent"
    )
    val abbreviations = nameList.map { it.substring(0, 3).toUpperCase() }
    println(abbreviations)

    val initials = nameList.map { it.substring(0, 3).toUpperCase() }
        .filterNot { it.contains("O") }
        .reversed()
    println(initials)
    println("-------------------------------------------------")

    /* map vs flatMap */
    val groceryBags = listOf(
        ShoppingBag(listOf("Grapes", "Apples", "Oranges")),
        ShoppingBag(listOf("Milk", "Eggs", "Pasta")),
        ShoppingBag(listOf("Bread", "Naan", "Cake"))
    )

    val retailBags = listOf(
        ShoppingBag(listOf("Shirt", "Pants", "Trousers")),
        ShoppingBag(listOf("Socks", "Shoes")),
        ShoppingBag(listOf("Jacket", "Sweater", "Scarf"))
    )

    val groceries = groceryBags.flatMap { it.items }
    println(groceries)

    val clothes = retailBags.map { it.items }
    println(clothes)
    println("----------------------------------------------")

    /* Kotlin Set - A list with no duplicates */
    val guys = setOf("Donn", "John", "Felix") // read only set
    println(guys)

    val girls = mutableSetOf("Lola", "Yomi", "Funmi")
    println(girls)
    girls.add("Jenifa")
    println(girls)
    girls.addAll(listOf("Zainab", "Esther", "Joy"))
    println(girls)

}

class ShoppingBag(val items: List<String>)