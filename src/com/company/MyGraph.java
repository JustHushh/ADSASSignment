package com.company;
import java.util.*;
import java.util.List;

class MyGraph {
    private int V;
    private Map<Vertex, List<Vertex>> map = new HashMap<>();
    private LinkedList<Integer> adj[];
    private Queue<Integer> queue;


    MyGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        queue = new LinkedList<Integer>();
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex v : map.keySet()) {
            count += map.get(v).size();
        }
        return count;
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int n) {

        boolean nodes[] = new boolean[V];
        int a = 0;

        nodes[n] = true;
        queue.add(n);

        while (queue.size() != 0) {
            n = queue.poll();
            System.out.print(n + " ");

            for (int i = 0; i < adj[n].size(); i++) {
                a = adj[n].get(i);
                if (!nodes[a]) {
                    nodes[a] = true;
                    queue.add(a);
                }
            }
        }
    }
}