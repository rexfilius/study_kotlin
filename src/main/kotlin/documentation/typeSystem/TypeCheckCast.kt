package typeSystem

import getAnObject

fun main() {

    // To perform a runtime check whether an object conforms to a given type,
    // use the 'is' or '!is' operator.
    val obj: Any = getAnObject()
    if (obj is String) {
        print(obj.lowercase())
    }
    if (obj !is String) {
        print("Not a string")
    } else {
        print(obj.length)
    }

    // Generally, Smart casting follow some rules -> CHECK DOCUMENTATION
    // Smart cast works for 'when' expressions and 'while' loops
    when (obj) {
        is Int -> print(obj + 1)
        is String -> print(obj.length + 1)
        is IntArray -> print(obj.sum())
    }

}

fun demo(x: Any) {
    if (x is String) {
        print(x.length)
    }
}

fun demo2(x: Any) {
    if (x !is String) return
    print(x.length)  // typeSystem.getX is automatically cast to String
}

fun demo3(x: Any) {
    // typeSystem.getX is automatically cast to string on the right-hand side of '||'
    if (x !is String || x.length == 0) return
}

fun demo4(x: Any) {
    // typeSystem.getX is automatically cast to string on the right-hand side of '&&'
    if (x is String && x.length > 0) {
        print(x.length)
    }
}

