package revision.trees.tuf;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsBSTIterative {
    public boolean isBST(TreeNode root) {
        if (root == null) return true;

        Stack<NodeRange> stack = new Stack<>();
        stack.push(new NodeRange(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while (!stack.isEmpty()) {
            NodeRange current = stack.pop();
            TreeNode node = current.node;
            long min = current.min;
            long max = current.max;

            if (node.data <= min || node.data >= max) {
                return false;
            }

            if (node.right != null) {
                stack.push(new NodeRange(node.right, node.data, max));
            }
            if (node.left != null) {
                stack.push(new NodeRange(node.left, min, node.data));
            }
        }

        return true;
    }

    public boolean isBSTBFS(TreeNode root) {
        if (root == null) return true;

        Queue<NodeRange> queue = new LinkedList<>();
        queue.offer(new NodeRange(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while (!queue.isEmpty()) {
            NodeRange current = queue.poll();
            TreeNode node = current.node;
            long min = current.min;
            long max = current.max;

            if (node.data <= min || node.data >= max) {
                return false;
            }

            if (node.left != null) {
                queue.offer(new NodeRange(node.left, min, node.data));
            }

            if (node.right != null) {
                queue.offer(new NodeRange(node.right, node.data, max));
            }
        }

        return true;
    }


    // Helper class to store node and its valid range
    private static class NodeRange {
        TreeNode node;
        long min;
        long max;

        NodeRange(TreeNode node, long min, long max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

}
