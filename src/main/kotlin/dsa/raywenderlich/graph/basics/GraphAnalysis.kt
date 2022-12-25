package raywenderlich.graph.basics

/**
 * For AdjacencyList:
 * Storage space = O(V+E)
 * Add vertex = O(1)
 * Add Edge = O(1)
 * Finding edges and weight = O(V)
 *
 * V represent vertices. E represents Edges
 *
 * For AdjacencyMatrix:
 * Storage space = O(V-squared)
 * Add vertex = O(V-squared)
 * Add edge = O(1)
 * Finding edges and weight = O(1)
 *
 * If there are few edges in your graph, it's considered a SPARSE GRAPH, and an
 * adjacency list would be a good fit. An adjacency matrix would be a bad choice for
 * a sparse graph, because a lot of memory will be wasted since there aren't
 * many edges.
 *
 * If your graph has lots of edges, it's considered a DENSE GRAPH, and an adjacency
 * matrix would be a better fit as you'd be able to access your weights and edges far
 * more quickly.
 */