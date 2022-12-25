package raywenderlich.graph.basics

/**
 * - An adjacency matrix uses a square matrix to represent a graph. This matrix is a
 * two-dimensional array wherein the value of "matrix(row)(column)" is the weight of
 * the edge between the vertices at row and column.
 * - Edges that don't exist have a weight of 0.
 */
class AdjacencyMatrix<T> : MyGraphInterface<T> {

    private val vertices = arrayListOf<MyVertex<T>>()
    private val weights = arrayListOf<ArrayList<Double?>>()

    override fun createVertex(data: T): MyVertex<T> {
        val vertex = MyVertex(index = vertices.count(), data)
        // Add a new vertex to the array
        vertices.add(vertex)
        // Append a null weight to every row in the matrix, as none of the current
        // vertices have an edge to the new vertex
        weights.forEach {
            it.add(null)
        }

        val row = ArrayList<Double?>(vertices.count())
        repeat(vertices.count()) {
            row.add(null)
        }
        // Add a new row to the matrix. This row holds the outgoing edges for the
        // new vertex. You put a null value in this row for each vertex that
        // your graph stores.
        weights.add(row)
        return vertex
    }

    override fun addDirectedEdge(
        source: MyVertex<T>,
        destination: MyVertex<T>,
        weight: Double?
    ) {
        weights[source.index][destination.index] = weight
    }

    override fun edges(source: MyVertex<T>): ArrayList<MyEdge<T>> {
        val edges = arrayListOf<MyEdge<T>>()
        (0 until weights.size).forEach { column ->
            val weight = weights[source.index][column]
            if (weight != null) {
                edges.add(MyEdge(source, vertices[column], weight))
            }
        }
        return edges
    }

    override fun weight(source: MyVertex<T>, destination: MyVertex<T>): Double? {
        return weights[source.index][destination.index]
    }

    override fun toString(): String {
        val verticesDescription = vertices.joinToString(separator = "\n") {
            "${it.index}: ${it.data}"
        }

        val grid = weights.map { row ->
            buildString {
                (0 until weights.size).forEach { columnIndex ->
                    val value = row[columnIndex]
                    if (value != null) append("$value\t")
                    else append("ø\t\t")
                }
            }
        }

        val edgesDescription = grid.joinToString("\n")
        return "$verticesDescription\n\n$edgesDescription"
    }
}