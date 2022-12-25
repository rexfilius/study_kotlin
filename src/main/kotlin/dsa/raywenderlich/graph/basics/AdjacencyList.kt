package raywenderlich.graph.basics

/**
 * - In an adjacency list; for every vertex in the graph, the graph stores a list
 * of outgoing edges.
 * - An adjacency list is created by storing a map of arrays. Each key in the map is
 * a vertex, and in every vertex, the map holds a corresponding array of edges.
 */
class AdjacencyList<T> : MyGraphInterface<T> {

    private val adjacencies: HashMap<MyVertex<T>, ArrayList<MyEdge<T>>> = HashMap()

    val vertices
        get() = ArrayList(adjacencies.keys)

    val verticesSet: Set<MyVertex<T>>
        get() = adjacencies.keys

    /**
     * Create a new vertex and return it. In the adjacency list, you store an empty
     * list of edges for this new vertex.
     */
    override fun createVertex(data: T): MyVertex<T> {
        val vertex = MyVertex(index = adjacencies.count(), data)
        adjacencies[vertex] = ArrayList()
        return vertex
    }

    override fun addDirectedEdge(
        source: MyVertex<T>,
        destination: MyVertex<T>,
        weight: Double?
    ) {
        val edge = MyEdge(source, destination, weight)
        adjacencies[source]?.add(edge)
    }

    /**
     * Return the stored edges or an empty list if the source vertex is unknown.
     */
    override fun edges(source: MyVertex<T>): ArrayList<MyEdge<T>> {
        return adjacencies[source] ?: arrayListOf()
    }

    /**
     * Here, you find the first edge from source to destination; if there is one,
     * you return its weight.
     */
    override fun weight(source: MyVertex<T>, destination: MyVertex<T>): Double? {
        return edges(source).firstOrNull {
            it.destination == destination
        }?.weight
    }

    override fun toString(): String = buildString {
        adjacencies.forEach { (vertex, edges) ->
            val edgeString = edges.joinToString {
                it.destination.data.toString()
            }
            append("${vertex.data} ---> [ $edgeString ]\n")
        }
    }

    /**copies all of a graph’s vertices into a new graph.*/
    fun copyVertices(graph: AdjacencyList<T>) {
        graph.verticesSet.forEach {
            adjacencies[it] = arrayListOf()
        }
    }

}