package graphs.dfs;

import java.util.*;

public class PrintGraph {
    public void printGraphIterative(int n, int[][] edges, int source) {
        List<List<Integer>> adjacencyArrayList = new ArrayList<>();

        // Step 1: Build adjacency list
        for (int i = 0; i < n; i++) {
            adjacencyArrayList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyArrayList.get(u).add(v);
            adjacencyArrayList.get(v).add(u); // since undirected
        }
        boolean[] visitedNodeList = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        System.out.print("DFS Traversal: ");

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();

            if (!visitedNodeList[currentNode]) {
                visitedNodeList[currentNode] = true;
                System.out.print(currentNode + " ");
                for (int neighbor : adjacencyArrayList.get(currentNode)) {
                    if (!visitedNodeList[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

}
