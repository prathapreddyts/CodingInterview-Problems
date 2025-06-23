package revision.trees.bfs;

import revision.trees.TreeNode;

import java.util.*;

public class VerticalLevelOrder {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        // TreeMap to store the nodes at each vertical position
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> nodesMap =
                new TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>>();

        // Queue for BFS traversal
        Queue<Tuple> queue = new LinkedList<Tuple>();
        queue.offer(new Tuple(root, 0, 0)); // (node, vertical, level)


        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int vertical = tuple.vertical;
            int level = tuple.level;

            // Classic putIfAbsent
            if (!nodesMap.containsKey(vertical)) {
                nodesMap.put(vertical, new TreeMap<Integer, PriorityQueue<Integer>>());
            }
            TreeMap<Integer, PriorityQueue<Integer>> levelMap = nodesMap.get(vertical);
            if (!levelMap.containsKey(level)) {
                levelMap.put(level, new PriorityQueue<Integer>());
            }
            levelMap.get(level).offer(node.data);


            //Classical addition of left and right nodes to queue
            if (node.left != null) {
                queue.offer(new Tuple(node.left, vertical - 1, level + 1));
            }

            if (node.right != null) {
                queue.offer(new Tuple(node.right, vertical + 1, level + 1));
            }
        }
        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> verticalEntry : nodesMap.entrySet()) {
            List<Integer> column = new ArrayList<Integer>();
            TreeMap<Integer, PriorityQueue<Integer>> levelMap = verticalEntry.getValue();

            for (Map.Entry<Integer, PriorityQueue<Integer>> levelEntry : levelMap.entrySet()) {
                PriorityQueue<Integer> pq = levelEntry.getValue();
                while (!pq.isEmpty()) {
                    column.add(pq.poll());
                }
            }
            result.add(column);
        }
        return result;
    }

}
