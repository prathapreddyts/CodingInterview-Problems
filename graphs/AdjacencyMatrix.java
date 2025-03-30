package graphs;

import java.util.*;

public class AdjacencyMatrix {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> resultAdjacencyList = new ArrayList<>();
        for(int i=0;i<V;i++){
            resultAdjacencyList.add(new ArrayList<Integer>());
        }

        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            List<Integer> edgesList = resultAdjacencyList.get(u);
            edgesList.add(v);

        }
        return resultAdjacencyList;
    }
}
