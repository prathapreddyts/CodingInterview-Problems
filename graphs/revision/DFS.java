package graphs.revision;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public int numProvinces(int[][] adj) {
        int count = 0;


        return count;
    }

    public List<List<Integer>> convertToAdjList(int[][] adj) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < adj.length; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                if (i != j && adj[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }
        return adjList;

    }
}
