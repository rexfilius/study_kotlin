package raywenderlich.intro

fun main() {

    var car: Car?

    // let function
    car = Car()
    car.doors = 1
    printCarLet(car)


}

/**
 * let FUNCTION
 * The let function helps you with null-checks and creates a new local scope to safely
 * perform operations. Inside let, it is the unwrapped value of car. Since you’re using
 * the safe-call operator ?., the code block won’t run if car is null. That’s how the
 * compiler can unwrap it without complaining. As you might notice, let can return
 * anything. In this case, it returns a Boolean telling you if the printed car was a coupé.
 * let uses the instance of the class as 'this' inside the block,
 * and the target object as 'it'
 */
fun printCarLet(car: Car?) {
    val isCoupe = car?.let {
        it.doors <= 2
    }
    if (isCoupe == true) println("Coupes are awesome")
}

/**
 * run FUNCTION
 * run is similar to let, but it’s more focused on the target object — the one you’re
 * using to call the function. Inside the block, run passes the target object as this
 * and isolates the block from the outer scope. Same raywenderlich.util.example as 'let', but now you’re
 * isolated inside run. The return value can still be anything
 */
fun printCarRun(car: Car?) {
    val isCoupe = car?.run {
        (this.doors <= 2)
    }
    if (isCoupe == true) println("Coupes are awesome")
}

/**
 * 'run' & 'let' are "transformational" functions. They’re called "transformational"
 * because the object they return can be different from the object you call the function
 * on. This is not the case with “mutating” functions - 'also' & 'apply'
 */

/**
 * also FUNCTION
 * If you try to replace run with also, you’ll get compile errors. Unlike with let or run
 * which return a transformation, the also function returns the original object.
 * Now, don’t get tricked into thinking that original means that it’s unmodified. It’s
 * just the same object. 'also' uses 'it' to refer to the object inside of the block and
 * has access to the outer scope using 'this'
 * ...
 * Since 'also' returns the same car object, you can use it to mutate the object and then
 * chain other calls to it. In this raywenderlich.util.example, the check to see if the car is a coupe is
 * within a let block, but since it was modified to have 4 doors within also, it won’t
 * print "Coupes are awesome"
 */
fun printCarAlso(car: Car?) {
    car?.also {
        it.doors = 4
    }.let {
        if (it?.doors != null && it.doors <= 2) {
            println("Coupes are awesome")
        }
    }
}

/**
 * apply FUNCTION
 * 'apply' is an 'also' that is isolated like 'run'. It returns the same object as the
 * target, and it uses 'this' inside the block
 */
fun printCarApply(car: Car?) {
    car?.apply {
        doors = 4
    }.let {
        if (it?.doors != null && it.doors <= 2) {
            println("Coupes are awesome")
        }
    }
}

class Car {
    var doors: Int = 0
}