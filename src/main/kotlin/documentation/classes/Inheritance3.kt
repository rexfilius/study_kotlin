package classes

/**
 * Code in a derived class can call its superclass functions and property accessors
 * implementations using the super keyword
 */
open class Rectangle4 {
    open fun draw() {
        println("Drawing a rectangle")
    }

    val borderColor: String
        get() = "black"
}

class FilledRectangle : Rectangle4() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String
        get() = super.borderColor
}

/**
 * Inside an inner class, accessing the superclass of the outer class is done with
 * the super keyword qualified with the outer class name 'super@Outer'
 */
class FilledRectangle2 : Rectangle4() {
    override fun draw() {
        val filler = Filler()
        filler.drawAndFill()
    }

    inner class Filler {
        fun fill() {
            println("Filling")
        }

        fun drawAndFill() {
            // class Rectangle4's implementation of draw()
            super@FilledRectangle2.draw()
            fill()
            println("filled rectangle with color ${super@FilledRectangle2.borderColor}")
        }
    }
}

/**
 * OVERRIDING RULES: if a class inherits multiple implementations of the same member
 * from its immediate superclasses, it must override this member and provide
 * its own implementation (perhaps, using one of the inherited ones).
 * To denote the supertype from which the inherited implementation is taken,
 * use super qualified by the supertype name in angle brackets, e.g. super<Base>
 */
open class Rectangle5 {
    open fun draw() { /*...*/
    }
}

interface Polygon3 {
    // interface members are open by default
    fun draw() { /*..*/
    }
}

class Square() : Rectangle5(), Polygon3 {
    override fun draw() {
        super<Rectangle5>.draw()
        super<Polygon3>.draw()
    }

}

fun main() {
    val filledRectangle = FilledRectangle()
    filledRectangle.draw()
    println()

    val filledRectangle2 = FilledRectangle2()
    filledRectangle2.draw()
}