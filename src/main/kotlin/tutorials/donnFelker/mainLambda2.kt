fun main() {

    /* you can use underscore in a lambda for unused parameters */
    loremIpsum(5) { _, word ->
        print(word)
        print(" ")
    }
}

fun loremIpsum(times: Int, block: (Int, String) -> Unit) {
    repeat(times) { index ->
        val word = latinWords.random()
        block(index, word)
    }
}

val latinWords = listOf(
    "Lorem", "ipsum", "dolor", "sit", "amet",
    "consectetur", "adipiscing", "elit",
    "sed", "do", "eiusmod", "tempor",
    "incididunt", "ut", "labore", "et", "dolore",
    "magna", "aliqua", "Ut", "enim", "ad", "minim", "veniam",
    "quis", "nostrud", "exercitation", "ullamco", "laboris",
    "nisi", "ut", "aliquip", "ex", "ea", "commodo", "consequat",
    "Duis", "aute", "irure", "dolor", "in", "reprehenderit", "in",
    "voluptate", "velit", "esse", "cillum", "dolore", "eu",
    "fugiat", "nulla", "pariatur", "Excepteur", "sint",
    "occaecat", "cupidatat", "non", "proident",
    "sunt", "in", "culpa", "qui", "officia",
    "deserunt", "mollit", "anim", "id", "est", "laborum",
)