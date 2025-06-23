package revision.trees.bfs;

import revision.trees.TreeNode;

import java.util.*;

public class TreeTopView {
    public List<Integer> topView(TreeNode root) {
        ArrayList<Integer> topViewTreeList = new ArrayList<>();
        return topViewHelper(root, topViewTreeList);

    }

    public List<Integer> topViewHelper(TreeNode root, ArrayList<Integer> topViewTreeList) {
        Map<Integer, ArrayList<Integer>> verticalLevelOrderMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;


        Queue<Pair> nodeQueue = new LinkedList<>();
        nodeQueue.add(new Pair(root, 0));
        while (!nodeQueue.isEmpty()) {
            Pair polledNode = nodeQueue.poll();
            TreeNode treeNode = polledNode.node;
            int verticalLevel = polledNode.verticalLevel;

            min = Math.min(verticalLevel, min);
            max = Math.max(verticalLevel, max);

            // Add the value to the corresponding level index
            verticalLevelOrderMap.putIfAbsent(verticalLevel, new ArrayList<>());
            verticalLevelOrderMap.get(verticalLevel).add(treeNode.data);

            //add left node
            if (treeNode.left != null) {
                nodeQueue.add(new Pair(treeNode.left, verticalLevel - 1));
            }
            //add right node
            if (treeNode.right != null) {
                nodeQueue.add(new Pair(treeNode.right, verticalLevel + 1));
            }

        }
        for (int i = min; i <= max; i++) {
            if (verticalLevelOrderMap.containsKey(i)) {
                topViewTreeList.add(verticalLevelOrderMap.get(i).get(0));
            }
        }
        return topViewTreeList;
    }
}
