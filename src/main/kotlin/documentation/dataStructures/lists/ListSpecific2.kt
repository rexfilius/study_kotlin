package dataStructures.lists

import kotlin.math.sign

fun main() {

    /**
     * Find Element Position - BINARY SEARCH IN SORTED LISTS
     * There is one more way to search elements in lists: binary search. It works
     * significantly faster than other built-in search functions but requires the list to
     * be sorted in ascending order according to a certain ordering: natural or another
     * one provided in the function parameter. Otherwise, the result is undefined.
     * ...
     * To search an element in a sorted list, call the binarySearch() function passing the
     * value as an argument. If such an element exists, the function returns its index;
     * otherwise, it returns (-insertionPoint - 1) where insertionPoint is the index where
     * this element should be inserted so that the list remains sorted. If there is more
     * than one element with the given value, the search can return any of their indices.
     * ...
     * You can also specify an index range to search in: in this case, the function
     * searches only between two provided indices
     */
    val aNumbers = mutableListOf("one", "two", "three", "four")
    aNumbers.sort()
    println(aNumbers)
    println(aNumbers.binarySearch("two"))    // 3
    println(aNumbers.binarySearch("z"))    // -5
    println(aNumbers.binarySearch("two", 0, 2))  // -3
    println()

    /**
     * COMPARATOR BINARY SEARCH:
     * When list elements aren't Comparable, provide a Comparator to use in the binary
     * search. The list must be sorted in ascending order according to this Comparator
     * ...
     * In the code below, here's a list of Product instances that aren't Comparable and a
     * Comparator that defines the order: product p1 precedes product p2 if p1's price is
     * less than p2's price. So, having a list sorted ascending according to this order,
     * we use binarySearch() to find the index of the specified Product.
     */
    val productList = listOf(
            Product("WebStorm", 49.0),
            Product("AppCode", 99.0),
            Product("DotTrace", 129.0),
            Product("ReSharper", 149.0))

    println(productList.binarySearch(Product("AppCode", 99.0),
            compareBy<Product> { it.price }.thenBy { it.name })
    )
    println()

    // Custom comparators are also handy when a list uses an order different from natural
    // one e.g. a case-insensitive order for String elements
    val colors = listOf("Blue", "green", "ORANGE", "Red", "yellow")
    println(colors.binarySearch("RED", String.CASE_INSENSITIVE_ORDER))
    println()

    /**
     * COMPARISON BINARY SEARCH
     * Binary search with comparison function lets you find elements without providing
     * explicit search values. Instead, it takes a comparison function mapping elements to
     * Int values and searches for the element where the function returns zero. The list
     * must be sorted in the ascending order according to the provided function; i.e.
     * the return values of comparison must grow from one list element to the next one.
     * Both comparator and comparison binary search can be performed for list ranges as well.
     */
    val aProductList = listOf(
            Product("WebStorm", 49.0),
            Product("AppCode", 99.0),
            Product("DotTrace", 129.0),
            Product("ReSharper", 149.0))

    println(aProductList.binarySearch { priceComparison(it, 99.0) })

}

data class Product(val name: String, val price: Double)

fun priceComparison(product: Product, price: Double) =
        sign(product.price - price).toInt()
