package functionalprogramming

/*fun duplicateNonZero(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0) return listOf()
        listOf(it, it)
    }
}*/

// A better way
/*fun duplicateNonZero(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0) return@flatMap listOf<Int>()
        listOf(it, it)
    }
}*/

// Another way
fun duplicateNonZeroLocalFunction(list: List<Int>): List<Int> {
    fun duplicateNonZeroElement(e: Int): List<Int> {
        if (e == 0) return listOf()
        return listOf(e, e)
    }
    return list.flatMap(::duplicateNonZeroElement)
}

// Another way - Anonymous Function
/*fun duplicateNonZero(list: List<Int>): List<Int> {
    return list.flatMap(fun (e): List<Int> {
        if (e == 0) return listOf()
        return listOf(e, e)
    })
}*/

// Another way - no 'return'
fun duplicateNonZero(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0)
            listOf()
        else
            listOf(it, it)
    }
}

fun main() {
    println(duplicateNonZero(listOf(3,0,5)))
    //println(duplicateNonZeroLocalFunction(listOf(3,0,5)))

}