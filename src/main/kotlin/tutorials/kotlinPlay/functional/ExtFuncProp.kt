package functional

import newLine

/**
 * Kotlin lets you add new members to any class with the extensions mechanism. Namely,
 * there are two types of extensions: extension functions and extension properties. They
 * look a lot like normal functions and properties but with one important difference:
 * you need to specify the type that you extend.
 */
data class Item(val name: String, val price: Float)

data class Order(val items: Collection<Item>)

/**
 * Adds extension functions for the Order type.
 */
fun Order.maxPricedItemValue(): Float =
    this.items.maxByOrNull { it.price }?.price ?: 0F

fun Order.maxPricedItemName() =
    this.items.maxByOrNull { it.price }?.name ?: "NO_PRODUCTS"

/**
 * Adds an extension property for the Order type.
 */
val Order.commaDelimitedItemNames: String
    get() = items.joinToString { it.name }

fun main() {

    val order = Order(
        listOf(
            Item("Bread", 25.0F),
            Item("Wine", 29.0F),
            Item("Water", 12.0F)
        )
    )

    // Calls extension functions directly on an instance of Order.
    println("Max priced item name: ${order.maxPricedItemName()}")
    println("Max priced item value: ${order.maxPricedItemValue()}")

    // Accesses the extension property on an instance of Order.
    println("Items: ${order.commaDelimitedItemNames}")
    "" newLine ""

    val s = "John"
    val d: String? = null
    println(s.nullSafeToString())
    println(d.nullSafeToString())
}

/**
 * It is even possible to execute extensions on null references. In an extension function,
 * you can check the object for null and use the result in your code
 */
fun <T> T?.nullSafeToString() = this?.toString() ?: "NULL"