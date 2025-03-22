package trees.levelordertraversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagLevelOrder = new ArrayList<>();
        if (root == null) {
            return zigzagLevelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode polledNode = queue.poll();
                if (leftToRight) {
                    currentLevel.add(polledNode.val);
                } else {
                    currentLevel.add(0, polledNode.val);
                }
                if (polledNode.left != null) {
                    queue.add(polledNode.left);
                }
                if (polledNode.right != null) {
                    queue.add(polledNode.right);
                }
            }
            zigzagLevelOrder.add(currentLevel);
            leftToRight = !leftToRight;
        }
        return zigzagLevelOrder;
    }
}
