package classes

open class Human(var name: String, var age: Int) {

    /* with 'protected' modifier,
    * only inside this class and its subclasses
    * can this property be used */
    protected var favoriteFood: String = "unknown"

    fun info() {
        println("This person's name is $name and they are $age years old")
    }

    /* with the 'protected' modifier on this method
    *  this function can only be called inside this class and its sub-classes */
    protected fun printMyFavoriteFood() {
        println(favoriteFood)
    }
}

class Chef(name: String, age: Int, favFood: String): Human(name, age) {
    init {
        favoriteFood = favFood
    }

    fun setMyFavoriteFood(food: String) {
        favoriteFood = food
    }
}