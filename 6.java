package tugas.tugas2;

import java.util.*;

public class tugas2 {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    tugas2(int v) {
        vertices = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjacencyList[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int n : adjacencyList[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v) {
        boolean[] visited = new boolean[vertices];
        DFSUtil(v, visited);
    }

    void BFS(int s) {
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");

            for (int n : adjacencyList[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        tugas2 g = new tugas2(12);

        g.addEdge(1, 3);
        g.addEdge(1, 5);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(3, 7);
        g.addEdge(4, 10);
        g.addEdge(5, 2);
        g.addEdge(5, 6);
        g.addEdge(5, 9);
        g.addEdge(6, 1);
        g.addEdge(7, 8);
        g.addEdge(7, 11);
        g.addEdge(8, 4);
        g.addEdge(11, 1);

        System.out.println("Depth First Traversal : ");
        g.DFS(1);

        System.out.println("\nBreadth First Traversal : ");
        g.BFS(1);
    }
}
