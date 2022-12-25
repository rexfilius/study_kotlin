package raywenderlich.graph

import raywenderlich.graph.basics.AdjacencyList
import raywenderlich.graph.basics.MyEdge
import raywenderlich.graph.basics.MyVertex
import raywenderlich.queue.priorityQueue.MyPriorityQueueComparator

class Dijkstra<T>(private val graph: AdjacencyList<T>) {

    fun shortestPath(
        destination: MyVertex<T>,
        paths: HashMap<MyVertex<T>, Visit<T>>
    ): ArrayList<MyEdge<T>> {
        return route(destination, paths)
    }

    fun shortestPath(start: MyVertex<T>): HashMap<MyVertex<T>, Visit<T>> {
        val paths: HashMap<MyVertex<T>, Visit<T>> = HashMap()
        // Define paths and initialize it with the start vertex.
        paths[start] = Visit(VisitType.START)

        // Create a Comparator which uses distances between vertices for sorting
        val distanceComparator = Comparator<MyVertex<T>> { first, second ->
            (distance(second, paths) - distance(first, paths)).toInt()
        }
        // Use the previous Comparator and create a min-priority queue to store
        // the vertices that must be visited.
        val priorityQueue = MyPriorityQueueComparator(distanceComparator)
        // Enqueue the start vertex as the first vertex to visit.
        priorityQueue.enqueue(start)

        while (true) {
            // You continue Dijkstra's algorithm to find the shortest paths until
            // you've visited all the vertices have been visited. This happens once
            // the priority queue is empty.
            val vertex = priorityQueue.dequeue() ?: break
            // For the current vertex, you go through all its neighboring edges.
            val edges = graph.edges(vertex)
            edges.forEach {
                // You make sure the edge has a weight.
                // If not, you move on to the next edge.
                val weight = it.weight ?: return@forEach
                if (paths[it.destination] == null
                    || distance(vertex, paths) + weight
                    < distance(it.destination, paths)
                ) {
                    // If the destination vertex has not been visited before, or you've
                    // found a cheaper path, you update the path and add the
                    // neighboring vertex to the priority queue.
                    paths[it.destination] = Visit(VisitType.EDGE, it)
                    priorityQueue.enqueue(it.destination)
                }
            }
        }
        return paths
    }

    private fun distance(
        destination: MyVertex<T>,
        paths: HashMap<MyVertex<T>, Visit<T>>
    ): Double {
        // Construct the path to the destination vertex.
        // sumOf sums the weights of all the edges.
        val path = route(destination, paths)
        return path.sumOf {
            it.weight ?: 0.0
        }
    }

    private fun route(
        destination: MyVertex<T>,
        paths: HashMap<MyVertex<T>, Visit<T>>
    ): ArrayList<MyEdge<T>> {
        // Start at the destination vertex.
        var vertex = destination
        // Create a list of edges to store the path.
        val path = arrayListOf<MyEdge<T>>()

        loop@ while (true) {
            val visit = paths[vertex] ?: break
            when (visit.type) {
                // As long as you've not reached the start case,
                // continue to extract the next edge.
                VisitType.EDGE -> visit.edge?.let {
                    // Add this edge to the path.
                    path.add(it)
                    // Set the current vertex to the edge's source vertex. This moves
                    // you closer to the start vertex.
                    vertex = it.source
                }
                // Once the while loop reaches the start case, you've completed
                // the path and return it.
                VisitType.START -> break@loop
            }
        }
        return path
    }

    fun getAllShortestPath(source: MyVertex<T>)
            : HashMap<MyVertex<T>, ArrayList<MyEdge<T>>> {
        val paths = HashMap<MyVertex<T>, ArrayList<MyEdge<T>>>()
        val pathsFromSource = shortestPath(source)

        graph.vertices.forEach {
            val path = shortestPath(it, pathsFromSource)
            paths[it] = path
        }

        return paths
    }


}

class Visit<T>(val type: VisitType, val edge: MyEdge<T>? = null)

enum class VisitType {
    START, EDGE
}