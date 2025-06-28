package revision.trees.iterativetraversals;

import revision.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderIterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        return inorderTraversalHelper(root, inorderList);
    }

    private List<Integer> inorderTraversalHelper(TreeNode root, List<Integer> inorderList) {
        if (root == null) {
            return inorderList;
        }
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode poppedNode = stack.pop();
            inorderList.add(poppedNode.data);
            current = current.right;
        }
        return inorderList;
    }

}
