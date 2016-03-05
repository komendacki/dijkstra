package com.dijkstra;

import com.dijkstra.model.Edge;
import com.dijkstra.model.Graph;
import com.dijkstra.model.Vertex;

import java.util.*;

/**
 * Created by Admin on 04.03.2016.
 */
public class DijkstraAlgorithm {
    private final List<Vertex> nodes;
    private final List<Edge> edges;
    private Set<Vertex> settledNodes;
    private Set<Vertex> unsettledNodes;
    private Map<Vertex, Vertex> predecessors;
    private Map<Vertex, Integer> distance;

    public DijkstraAlgorithm(Graph graph)
    {
        this.edges = new ArrayList<Edge>(graph.getEdges());
        this.nodes = new ArrayList<Vertex>(graph.getVertexes());
    }

    public void Execute (Vertex source) {
        settledNodes = new HashSet<Vertex>();
        unsettledNodes = new HashSet<Vertex>();
        distance = new HashMap<Vertex, Integer>();
        predecessors = new HashMap<Vertex, Vertex>();
        distance.put(source, 0);

        while (unsettledNodes.size() > 0) {
            Vertex node = getMinimum(unsettledNodes);
            settledNodes.add(node);
            unsettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(Vertex node)
    {
        List<Vertex> adjacentNodes = getNeighbors(node);
        for (Vertex target : adjacentNodes)
        {
            if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target))
            {
                distance.put(target, getShortestDistance(node) + getDistance(node, target));

            predecessors.put(target, node);
            unsettledNodes.add(target);
            }
        }
    }

    private int getDistance(Vertex node, Vertex target)
    {
        for (Edge edge : edges)
        {
                if (edge.getSource().equals(node) && edge.getDestination().equals(target))
                {
                    return edge.getWeight();
                }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<Vertex> getNeighbors(Vertex node)
    {
        List<Vertex> neighbors = new ArrayList<Vertex>();
        for (Edge edge : edges)
        {
            if (edge.getSource().equals(node) && !isSettled(edge.getDestination()))
            {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private Vertex getMinimum(Set<Vertex> vertexes)
    {
        Vertex minimum = null;
        for (Vertex vertex : vertexes)
        {
            if (minimum == null) minimum = vertex;
            else
            {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) minimum = vertex;
            }
        }
        return minimum;
    }

    private boolean isSettled(Vertex vertex)
    {
        return settledNodes.contains(vertex);
    }

    private int getShortestDistance(Vertex destination)
    {
        Integer d = distance.get(destination);
        if (d == null) return Integer.MAX_VALUE;
        else return d;
    }

    public LinkedList<Vertex> getPath(Vertex target)
    {
        LinkedList<Vertex> path = new LinkedList<Vertex>();
        Vertex step = target;

        if (predecessors.get(step) == null) return null;
        path.add(step);
        while(predecessors.get(step) != null)
        {
            step = predecessors.get(step);
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }
}
