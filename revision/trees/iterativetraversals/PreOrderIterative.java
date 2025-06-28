package revision.trees.iterativetraversals;

import revision.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderIterative {
    public List<Integer> preorder(TreeNode root) {
        return preorderIterativeHelper(root);
    }

    public List<Integer> preorderIterativeHelper(TreeNode root) {
        List<Integer> preOrderList = new ArrayList<>();
        if (root == null) {
            return preOrderList;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {

            TreeNode poppedNode = stack.pop();
            preOrderList.add(poppedNode.data);
            if (poppedNode.right != null) {
                stack.push(poppedNode.right);
            }
            if (poppedNode.left != null) {
                stack.push(poppedNode.left);
            }
        }
        return preOrderList;
    }
}
