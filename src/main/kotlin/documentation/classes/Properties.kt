package documentation.classes

/**
 * Properties in Kotlin classes can be declared either as mutable using 'var'
 * or as read-only using 'val'
 */
class Address {
    var name: String = "Holmes"
    var street: String = "Baker"
    var city: String = "London"
    var state: String? = null
    var zip: String = "123456"
}

// To use a property, simply refer to it by its name
fun copyAddress(address: Address): Address {
    val result = Address()
    result.name = address.name
    result.street = address.street
    return result
}

/**
 * The full syntax for declaring a property is the following:
 * ...
 * var <propertyName> : <PropertyType> = <property_initializer>
 *     <getter>
 *     <setter>
 * ...
 * The initializer, getter and setter are optional. Property type is optional
 * if it can be inferred from the initializer (or from the getter return type)
 */

// error: explicit initializer required, default getter and setter implied
// var allByDefault: Int?

// has type Int, default getter and setter
var initialized = 1

/**
 * The full syntax of a read-only property declaration differs from a mutable one in
 * two ways: it starts with val instead of var and does not allow a setter
 */

// has type Int, default getter, must be initialized in constructor
// val simple: Int?

// has type Int and a default getter
val inferredType = 1

/**
 * You can define custom accessors for a property. If you define a custom getter,
 * it will be called every time you access the property
 * (this way you can implement a computed property).
 * ...
 * If you define a custom setter, it will be called every time you assign
 * a value to the property
 */


