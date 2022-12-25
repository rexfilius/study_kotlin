package classes

fun main() {

    /*var user = User("Donn", "Felker", isPlatinum = true)

    user.printFullName()
    user.updateName("Bob")
    user.printFullName()
    user.printWithPrefix("Mr.")

    var friend = User("Jane", "Doe")

    friend.printFullName()
    friend.printWithPrefix("Ms.")
    friend.firstNameLength()

    var cousin = User(firstName = "Nick")*/

    /*var user = User("Donn", "Felker")
    println(user.fullName)

    user.fullName = "Jon"
    println(user.fullName)

    println("Length of ${user.fullName} is ${user.fullNameLength}")*/

    /*val user = User.createUser("Joe", "Rogan")
    println(user)
    val users = User.createUsers(5)
    println(users)*/

    /*println(FavoriteFood.name)
    FavoriteFood.name = "Beans"
    println(FavoriteFood.name)

    FavoriteFood.ingredients.add("Salt")
    println(FavoriteFood.ingredients.first())

    doStuff()
    println(FavoriteFood.name)
    println(FavoriteFood.ingredients.firstOrNull()) // using first() function gives exception

    println(FavoriteFood.numberOfIngredients())*/

    /* lateinit modifier */
    /*val user = User("Joe", "Kel")
    user.favoriteCity = "None"
    println(user.toString())*/

    /* nested and inner class */
    /*val vehicle = Vehicle()
    vehicle.brand = "BMW"
    vehicle.info()

    val sw = vehicle.SteeringWheel()
    sw.info()

    val transmission = Vehicle.Transmission()
    transmission.shift()*/

    /* enum class with constructor parameters */
    /*println(AccountType.GOLD)

    val accountTypeFromApi = "gold"
    val accountType = AccountType.valueOf(accountTypeFromApi.toUpperCase())
    println(accountType)

    println(AccountType.PLATINUM.discountPercent)

    for (accountType in AccountType.values()) {
        println("$accountType =====")
    }
    //OR
    AccountType.values().forEach { println("$it ++++") }

    val accountType2 = AccountType.getAccountTypeByName("gold")
    println(accountType)*/

    /* enum class with abstract function */
    /*val fromApi = "Gold"
    val accountType = AccountType2.valueOf(fromApi.toUpperCase())
    println(accountType.calculateDiscountPercent())*/
}

fun doStuff() {
    FavoriteFood.name = "Chicken"
    FavoriteFood.ingredients.clear()
}

/* this is a singleton */
object FavoriteFood {
    var name = "unknown"
    var ingredients = mutableListOf<String>()

    fun numberOfIngredients(): Int {
        return ingredients.size
    }
}

/* Nested Classes...
*  nested class do not have access to variables of outer class...
*  to have access to the outer class variables...
*  you have to modify the class with 'inner' keyword...
*  ...outer class is called like so -
*  'Vehicle.SteeringWheel'
*  ...inner class is called like so -
*  'val vehicle = Vehicle()'
*  'vehicle.SteeringWheel'*/
class Vehicle {
    var brand: String = "unknown"

    fun info() = println(brand)

    inner class SteeringWheel {
        var name = "Leather"
        fun info() = println("$brand is the brand of the vehicle with $name steering")
    }

    class Transmission {
        var type = "Automatic"
        fun shift() = println("The vehicle has shifted")
    }
}

/* enum class with constructors */
enum class AccountType(val discountPercent: Int) {
    BRONZE(10),
    SILVER(15),
    GOLD(20),
    PLATINUM(25);

    /* this acts like a static method */
    companion object {
        fun getAccountTypeByName(name: String) = valueOf(name.toUpperCase())
    }
}

/* enum class with abstract function */
enum class AccountType2 {
    BRONZE {
        override fun calculateDiscountPercent() = 5
    },
    SILVER {
        override fun calculateDiscountPercent() = 10
    },
    GOLD {
        override fun calculateDiscountPercent() = 15
    },
    PLATINUM {
        override fun calculateDiscountPercent() = 20
    };

    abstract fun calculateDiscountPercent(): Int
}
