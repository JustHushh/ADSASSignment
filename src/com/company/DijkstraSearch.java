package com.company;
import java.util.*;

public class DijkstraSearch<Vertex> extends Search<Vertex> {
    private Set<Vertex> Unods;
    private Map<Vertex, Double> waylong;
    private WeightedGraph<Vertex> graph;

    public void dijkstra() {
        waylong.put(source, 0D);
        Unods.add(source);
        while (Unods.size() > 0) {
            Vertex nodes = getVertexWithMinimumWeight(Unods);
            marked.add(nodes);
            Unods.remove(nodes);
            for (Vertex point : graph.adjacencyList(nodes)) {
                if (getShortestDistance(point) > getShortestDistance(nodes)
                        + getDistance(nodes, point)) {
                    waylong.put(point, getShortestDistance(nodes)
                            + getDistance(nodes, point));
                    edgeTo.put(point, nodes);
                    Unods.add(point);
                }
            }
        }
    }

    private double getDistance(Vertex nodes, Vertex point) {
        for (Edge<Vertex> edge : graph.getEdges(nodes)) {
            if (edge.getDest().equals(point))
                return edge.getWeight();
        }

        throw new RuntimeException("Not found!");
    }

    public DijkstraSearch(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);
        Unods = new HashSet<>();
        waylong = new HashMap<>();
        this.graph = graph;
        dijkstra();
    }

    private Vertex getVertexWithMinimumWeight(Set<Vertex> vertices) {
        Vertex minimum = null;
        for (Vertex vertex : vertices) {
            if (minimum == null)
                minimum = vertex;
            else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum))
                    minimum = vertex;
            }
        }
        return minimum;
    }

    private double getShortestDistance(Vertex destination) {
        Double d = waylong.get(destination);
        return (d == null ? Double.MAX_VALUE : d);
    }
}