package graphs.iterative;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSIterative {
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

}
