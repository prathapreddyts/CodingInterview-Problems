package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfProvince {

    public int numProvinces(int[][] adj) {
        int n = adj.length;
        List<List<Integer>> adjacencyList = convertToAdjacencyList(n, adj);
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, adjacencyList, visited);
                count++;
            }
        }
        return count;
    }

    private void bfs(int start, List<List<Integer>> adjacencyList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adjacencyList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    private List<List<Integer>> convertToAdjacencyList(int n, int[][] adj) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adj[i][j] == 1 && i != j) {
                    adjacencyList.get(i).add(j);
                }
            }
        }
        return adjacencyList;
    }
}
