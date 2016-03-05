package com.dijkstra;

import com.dijkstra.model.Edge;
import com.dijkstra.model.Vertex;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

    
}
