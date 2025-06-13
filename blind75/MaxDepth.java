package blind75;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pollTreeNode = queue.poll();
                if (pollTreeNode.left != null) {
                    queue.add(pollTreeNode.left);
                }
                if (pollTreeNode.right != null) {
                    queue.add(pollTreeNode.right);
                }
            }
            count++;
        }
        return count;
    }
}
