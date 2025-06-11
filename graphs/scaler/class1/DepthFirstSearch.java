package graphs.scaler.class1;

import java.util.*;

public class DepthFirstSearch {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> dfsResult = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        stack.push(0);
        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            if (!visited[currentNode]) {
                visited[currentNode] = true;
                dfsResult.add(currentNode);
                List<Integer> neighbors = adj.get(currentNode);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return dfsResult;
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> bfsResult = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            bfsResult.add(currentNode);

            for (int neighbor : adj.get(currentNode)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return bfsResult;
    }
}
