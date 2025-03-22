package trees;

import trees.levelordertraversals.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DiameterOfTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, Integer> depthMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        int diameter = 0;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && !depthMap.containsKey(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !depthMap.containsKey(node.right)) {
                stack.push(node.right);
            } else {
                stack.pop();
                int leftDepth = depthMap.getOrDefault(node.left, 0);
                int rightDepth = depthMap.getOrDefault(node.right, 0);
                depthMap.put(node, 1 + Math.max(leftDepth, rightDepth));
                diameter = Math.max(diameter, leftDepth + rightDepth);
            }
        }
        return diameter;
    }

}
