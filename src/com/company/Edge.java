package com.company;
import java.util.Objects;

public class Edge<Vertex> {
    private Vertex Roots;
    private Vertex dest;
    private Double weight;

    public Edge(Vertex Roots, Vertex dest, Double weight) {
        this.Roots = Roots;
        this.dest = dest;
        this.weight = weight;
    }

    public Edge(Vertex Roots, Vertex dest) {
        this.Roots = Roots;
        this.dest = dest;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(Roots, edge.Roots) &&
                Objects.equals(dest, edge.dest);
    }

    public Vertex getDestination() {
        return dest;
    }
    public void setRoots(Vertex Roots) {
        this.Roots = Roots;
    }

    public Vertex getRoots() {
        return Roots;
    }

    public void setDest(Vertex dest) {
        this.dest = dest;
    }

    public Vertex getDest() {
        return dest;
    }

}