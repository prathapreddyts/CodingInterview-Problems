package trees.levelordertraversals;

import java.util.*;

public class TreeTopView {

    public List<Integer> topViewOfTree(TreeNode root) {
        List<Integer> topViewList = new ArrayList<>();
        if (root == null) return topViewList;

        Queue<Pair> queue = new LinkedList<>();
        HashMap<Integer, List<Integer>> verticalOrderMap = new HashMap<>();
        int min = 0, max = 0; // Track the leftmost and rightmost levels

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair polledNode = queue.poll();
            TreeNode node = polledNode.node;
            int levelOrderIdx = polledNode.levelOrder;

            // Update min and max
            min = Math.min(min, levelOrderIdx);
            max = Math.max(max, levelOrderIdx);

            // Add the value to the corresponding level index
            verticalOrderMap.putIfAbsent(levelOrderIdx, new ArrayList<>());
            verticalOrderMap.get(levelOrderIdx).add(node.val);

            // Left child (levelOrderIdx - 1)
            if (node.left != null) {
                queue.add(new Pair(node.left, levelOrderIdx - 1));
            }
            // Right child (levelOrderIdx + 1)
            if (node.right != null) {
                queue.add(new Pair(node.right, levelOrderIdx + 1));
            }
        }

        // Collect the values from min to max
        for (int i = min; i <= max; i++) {
            if (verticalOrderMap.containsKey(i)) {
                topViewList.add(verticalOrderMap.get(i).get(0)); // Get the first (topmost) node
            }
        }

        return topViewList;
    }
}



