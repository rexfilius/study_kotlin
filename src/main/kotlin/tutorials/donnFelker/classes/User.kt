package classes

/* You don't need to use the 'constructor' keyword when
* creating a primary constructor for a class - there are 2 ways
* 1. class User constructor(var firstName: String, var lastName: String)
* 2. class User(var firstName: String, var lastName: String)
* You can also set 'default values' in a constructor,
* so that you don't need to create multiple constructors.
* Constructors can have modifiers - 'protected', 'internal'*/

class User(var firstName: String, var lastName: String, var isPlatinum: Boolean = false) {

    /* A secondary constructor (a class can have multiple constructors)
    *  and you don't need to provide a body for it,
    *  i.e the curly braces */
    /*constructor(firstName: String, lastName: String) :
            this(firstName, lastName, false) {
        println("isPlatinum is false by default")
    }

    constructor(firstName: String) : this(firstName, "Unknown") {
        println("I'm in the 3rd constructor")
    }*/

    // companion object - similar to static method in Java
    /*companion object {
        val users = mutableListOf<User>()

        fun createUsers(count: Int): List<User> {
            for (i in 1..count) {
                users.add(User("FirstName${i}", "LastName${i}"))
            }
            return users
        }

        fun createUser(firstName: String, lastName: String): User {
            return User(firstName, lastName)
        }
    }*/

    /* init blocks are called after the primary constructors
    * and you can have multiple init blocks
    * init block can have access to class properties */
    /*init {
        println("Hello from Init Block 1")
    }

    init {
        println("Hello from Init Block 2, greeting $fullName")
    }*/

    /* a local constant - scoped to the class instance
    * it can be called like so -
    * 'val user = User()'
    * 'user.MAX_AGE'
    *  you can modifier MAX_AGE as 'private'
    *  if you don't want it used outside the class */
    val MAX_AGE = 18

    /* a more appropriate constant declaration
    * this constant is not scoped to the class instance
    * so it can be called anywhere like so - 'User.MAX_AGE'
    * either way, you can also create a Kotlin file and put constants there */
    companion object {
        const val MAX_AGE = 18
    }

    /* 'lateinit' modifier
    *  and you can't use 'val' with 'lateinit' */
    lateinit var favoriteCity: String

    /* Classes can have properties
    *  and of course, you can have multiple properties */
    var fullName: String = "$firstName $lastName"
        get() = "Full Name: $field"
        set(value) {
            if (value.startsWith("Jon")) {
                field = "Jon Doe"
            } else {
                field = value
            }
        }

    var age: Int = 0
    var favoriteColor: String = "Blue"

    /* 'fullNameLength' is a read-only property */
    val fullNameLength = fullName.length

    /** CLASS FUNCTIONS BELOW **/

    fun printFullName(): String = "$firstName - $lastName"

    fun printWithPrefix(prefix: String) = println("$prefix $lastName")

    fun updateName(newName: String) {
        firstName = newName
    }

    fun firstNameLength() = println(firstName.length)

    override fun toString(): String {
        return printFullName()
    }

}