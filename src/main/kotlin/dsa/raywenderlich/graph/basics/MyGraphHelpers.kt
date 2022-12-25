package raywenderlich.graph.basics

enum class MyEdgeType {
    DIRECTED, UNDIRECTED
}

data class MyVertex<T>(
    val index: Int,
    val data: T
)

data class MyEdge<T>(
    val source: MyVertex<T>,
    val destination: MyVertex<T>,
    val weight: Double? = null
)

data class Ref<T>(var value: T)