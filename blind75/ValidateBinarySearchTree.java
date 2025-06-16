package blind75;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBinarySearchTree {
    static class NodeBound {
        TreeNode node;
        long lower;
        long upper;

        NodeBound(TreeNode node, long lower, long upper) {
            this.node = node;
            this.lower = lower;
            this.upper = upper;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        Queue<NodeBound> queue = new LinkedList<>();
        queue.add(new NodeBound(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while (!queue.isEmpty()) {
            NodeBound current = queue.poll();
            TreeNode node = current.node;
            long lower = current.lower;
            long upper = current.upper;

            if (node.val <= lower || node.val >= upper) {
                return false;
            }

            if (node.left != null) {
                queue.add(new NodeBound(node.left, lower, node.val));
            }

            if (node.right != null) {
                queue.add(new NodeBound(node.right, node.val, upper));
            }
        }

        return true;
    }
}
