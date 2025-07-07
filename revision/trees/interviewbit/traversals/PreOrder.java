package revision.trees.interviewbit.traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    public int[] preorderTraversal(TreeNode root) {
        return preOrderTraversalHelperIterative(root);
    }

    public int[] preOrderTraversalHelperIterative(TreeNode root) {
        if (root == null) return new int[0];

        List<Integer> preOrderList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            preOrderList.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        int[] result = new int[preOrderList.size()];
        for (int i = 0; i < preOrderList.size(); i++) {
            result[i] = preOrderList.get(i);
        }
        return result;
    }
}
