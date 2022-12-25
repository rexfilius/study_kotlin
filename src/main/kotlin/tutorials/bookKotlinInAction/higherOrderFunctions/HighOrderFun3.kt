package higherOrderFunctions

/**
 * The requirement to return a function from another function doesn't come up as
 * often as passing functions to other functions, but it's still useful.
 * e.g. imagine a piece of logic in a program that can vary depending on the state
 * of the program or other conditions - for example, calculating the cost of shipping
 * depending on the selected shipping method. You can define a function that chooses
 * the appropriate logic variant and returns it as another function.
 */
enum class Delivery { STANDARD, EXPEDITED }

class Order(val itemCount: Int)

/**
 * - To declare a function that returns another function, you specify a function type
 * as its return type.
 * - [getShippingCostCalculator] returns a function that takes an Order and returns
 * a Double
 * - To return a function, you write a return expression followed by a lambda,
 * a member reference, or another expression of a function type,
 * such as a local variable.
 */
fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
    if (delivery == Delivery.EXPEDITED) {
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return { order -> 1.2 * order.itemCount }
}

fun main() {
    val shipCalculator = getShippingCostCalculator(Delivery.EXPEDITED)
    println("Shipping costs ${shipCalculator(Order(3))}")
}