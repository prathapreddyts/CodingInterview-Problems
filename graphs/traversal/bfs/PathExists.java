package graphs.traversal.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathExists {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjacencyArrayList = adjacencyArrayList(n, edges);
        boolean[] visitedNodeList = new boolean[n];
        Queue<Integer> queue=new LinkedList();
        queue.add(source);
        while(!queue.isEmpty()){
            Integer polledEdge = queue.poll();
            if(polledEdge==destination){
                return true;
            }
            List<Integer> adjacentNodesList = adjacencyArrayList.get(polledEdge);
            for(int node:adjacentNodesList){
                if(visitedNodeList[node]==false){
                    queue.add(node);
                    visitedNodeList[polledEdge]=true;
                }
            }
        }
        return false;

    }
    public List<List<Integer>> adjacencyArrayList(int V, int edges[][]) {
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
