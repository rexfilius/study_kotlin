package documentation.classes

import java.awt.Rectangle

/**
 * All classes in Kotlin have a common superclass 'Any'
 * Any is the default superclass for a class with no supertypes declared
 * Any has 3 methods: equals(), hashCode(), toString()
 */
class Example    // implicitly inherits from Any

// By default, Kotlin classes are FINAL - they can't be inherited
// to make a class inheritable, mark it with the 'open' keyword
open class Base
open class Base2(p: Int)

/**
 * Declaring an explicit supertype...
 * if the derived class has a primary constructor, the base class can (and must) be
 * initialized right there, using the parameters of the primary constructor
 */
class Derived() : Base()
class Derived2(p: Int) : Base2(p)

/**
 * If the derived class has no primary constructor, then each secondary constructor
 * has to initialize the base type using the super keyword, or to delegate to another
 * constructor which does that. Note that in this case different secondary constructors
 * can call different constructors of the base type
 */
class MyShape : Rectangle {
    constructor(rect: Rectangle) : super(rect)
    constructor(width: Int, height: Int) : super(width, height)
    constructor(x: Int, y: Int, w: Int, h: Int) : super(x, y, w, h)
}

/**
 * Kotlin requires explicit modifiers for overridable members and overrides.
 * Declaring a method with the same signature in a subclass is illegal,
 * either with 'override' or without it.
 * ...
 * The 'open' modifier has no effect when added on members of a final class.
 * A member marked override is itself open, if you want
 * to prohibit re-overriding, use 'final'
 */
open class Shape {
    open fun draw() { /*...*/ }
    fun fill() {/*...*/ }
    open fun contour() { /*...*/ }
}
open class Circle() : Shape() {
    override fun draw() { /*...*/ }
    final override fun contour() { /*...*/ }
}
class RedCircle() : Circle() {
    override fun draw() { /*...*/ }
}