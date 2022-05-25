package com.company;
public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);

        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(graph, "Almaty");
        outputPath(djk, "Kyzylorda");

        MyGraph ngraph = new MyGraph(6);
        ngraph.addEdge(0, 1);
        ngraph.addEdge(0, 3);
        ngraph.addEdge(0, 4);
        ngraph.addEdge(4, 5);
        ngraph.addEdge(3, 5);
        ngraph.addEdge(1, 2);
        ngraph.addEdge(1, 0);
        ngraph.addEdge(2, 1);
        ngraph.addEdge(4, 1);
        ngraph.addEdge(3, 1);
        ngraph.addEdge(5, 4);
        ngraph.addEdge(5, 3);

        System.out.println(" ");
        System.out.print("The Breadth First Traversal of the graph is as follows : ");

        ngraph.BFS(0);
    }

    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
    }
}