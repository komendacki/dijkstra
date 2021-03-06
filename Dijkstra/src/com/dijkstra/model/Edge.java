package com.dijkstra.model;

/**
 * Created by Admin on 04.03.2016.
 */
public class Edge {
    private final String id;
    private final Vertex source;
    private final Vertex destination;
    private final int weight;

    public Edge(String id, Vertex source, Vertex destination, int weight)
    {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String getId()
    {
        return this.id;
    }

    public Vertex getDestination()
    {
        return this.destination;
    }

    public Vertex getSource()
    {
        return this.source;
    }

    public int getWeight()
    {
        return this.weight;
    }

    @Override
    public String toString()
    {
        return source + " " + destination;
    }
}
