package graphs.tufGraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumberOfProvinces {
    public int numProvinces(int[][] adj) {
        int V = adj.length;
        List<List<Integer>> adjList = convertToAdjList(adj);
        boolean[] visited = new boolean[V];
        int numOfProvinces = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsIterative(adjList, i, visited);
                numOfProvinces++;
            }
        }
        return numOfProvinces;
    }

    public void dfsIterative(List<List<Integer>> adjList, int start, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                for (int neighbor : adjList.get(current)) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public List<List<Integer>> convertToAdjList(int[][] matrix) {
        int V = matrix.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (matrix[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                }
            }
        }
        return adjList;
    }


}
