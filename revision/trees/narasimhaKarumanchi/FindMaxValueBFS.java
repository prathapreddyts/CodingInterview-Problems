package revision.trees.narasimhaKarumanchi;


import revision.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindMaxValueBFS {
    public int getMaxValue(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int maxValue = Integer.MIN_VALUE;

        Queue<TreeNode> levelOrder = new LinkedList<>();
        levelOrder.add(root);

        while (!levelOrder.isEmpty()) {
            TreeNode polledNode = levelOrder.poll();
            maxValue = Math.max(maxValue, polledNode.data);

            if (polledNode.left != null) {
                levelOrder.add(polledNode.left);
            }
            if (polledNode.right != null) {
                levelOrder.add(polledNode.right);
            }
        }

        return maxValue;
    }

}
