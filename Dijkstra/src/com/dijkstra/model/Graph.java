package com.dijkstra.model;

import java.util.List;

/**
 * Created by Admin on 04.03.2016.
 */
public class Graph {
    private final List<Vertex> vertexes;
    private final List<Edge> edges;

    public Graph(List<Vertex> vertexes, List<Edge> edges)
    {
        this.vertexes = vertexes;
        this.edges = edges;
    }

    public List<Vertex> getVertexes()
    {
        return this.vertexes;
    }

    public List<Edge> getEdges()
    {
        return this.edges;
    }
}
