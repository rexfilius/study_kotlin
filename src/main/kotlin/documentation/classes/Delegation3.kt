package documentation.classes

/**
 * A property can delegate its getter and setter to another property. Such delegation is
 * available for both top-level and class properties (member and extension).
 * The delegate property can be:
 * 1. a top-level property
 * 2. a member or an extension property of the same class
 * 3. a member or an extension property of another class
 * To delegate a property to another property, use the proper :: qualifier in the delegate
 * name, for example, this::delegate or MyClass::delegate
 */
var topLevelInt: Int = 0

class ClassWithDelegate(val anotherClassInt: Int)

class SampleClass(var memberInt: Int, val anotherClassInstance: ClassWithDelegate) {
    var delegatedToMember: Int by this::memberInt
    var delegatedToTopLevel: Int by ::topLevelInt
    val delegatedToAnotherClass: Int by anotherClassInstance::anotherClassInt
}

var SampleClass.extDelegated: Int by ::topLevelInt

// this is useful when you want to rename a property in a backward compatible way
class ThisClass {
    var newName: Int = 100

    @Deprecated("Use 'newName' instead", ReplaceWith("newName"))
    var oldName: Int by this::newName
}

/**
 * A common use case of delegation is storing the values of properties in a map.
 * This comes up often in applications like parsing JSON or doing other “dynamic” things.
 * In this case, you can use the map instance itself as the delegate
 * for a delegated property
 */
class User3(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

class MutableUser3(var map: MutableMap<String, Any?>) {
    var name: String by map
    var age: Int by map
}

fun main() {
    val thisClass = ThisClass()
    thisClass.oldName = 42
    println(thisClass.newName)
    println()

    val user3 = User3(
        mapOf(
            "name" to "John Doe",
            "age" to 25
        )
    )
    println("${user3.name}...${user3.age}")
}