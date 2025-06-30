package revision.trees.binarysearchtree;

import revision.trees.TreeNode;

import java.util.*;

public class InOrderIterative {
    public List<Integer> inorder(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        inOrderHelper(root, inOrderList);
        return inOrderList;
    }

    private void inOrderHelper(TreeNode root, List<Integer> inOrderList) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            TreeNode popped = stack.pop();
            inOrderList.add(popped.data);
            if (popped.right != null) {
                current = popped.right;
            }
        }
    }
}
