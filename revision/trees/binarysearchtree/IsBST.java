package revision.trees.binarysearchtree;

import revision.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IsBST {
    public boolean isBST(TreeNode root) {
        return isBSTHelper(root);
    }

    private boolean isBSTHelper(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrderHelper(root, inOrder);
        return isSortedArray(inOrder);
    }

    private void inOrderHelper(TreeNode root, List<Integer> inOrderList) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode popped = stack.pop();
            inOrderList.add(popped.data);
            current = popped.right;
        }
    }

    private boolean isSortedArray(List<Integer> inOrder) {
        for (int i = 1; i < inOrder.size(); i++) {
            if (inOrder.get(i - 1) >= inOrder.get(i)) {
                return false;
            }
        }
        return true;
    }

}
