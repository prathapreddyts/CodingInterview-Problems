package graphs.cycles;

import java.util.*;

public class CycleInDirectedGraph {
    public boolean isCyclic(int N, List<Integer>[] adj) {
        boolean[] visited = new boolean[N];
        boolean[] inStack = new boolean[N]; // tracks nodes in current DFS path
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (hasCycleDirected(i, adj, visited, inStack)) {
                    return true;
                }
            }
        }

        return false;
    }
    private boolean hasCycleDirected(int start, List<Integer>[] adj, boolean[] visited, boolean[] inStack) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Iterator<Integer>> iterMap = new HashMap<>();

        stack.push(start);
        iterMap.put(start, adj[start].iterator());
        visited[start] = true;
        inStack[start] = true;

        while (!stack.isEmpty()) {
            int current = stack.peek();
            Iterator<Integer> it = iterMap.get(current);

            if (it.hasNext()) {
                int neighbor = it.next();

                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    iterMap.put(neighbor, adj[neighbor].iterator());
                    visited[neighbor] = true;
                    inStack[neighbor] = true;
                } else if (inStack[neighbor]) {
                    return true;
                }
            } else {
                // All neighbors visited, backtrack
                stack.pop();
                inStack[current] = false;
            }
        }

        return false;
    }

}
