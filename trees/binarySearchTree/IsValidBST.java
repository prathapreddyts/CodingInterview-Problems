package trees.binarySearchTree;

import trees.levelordertraversals.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
    private boolean isValid(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max)
            return false; // Value must be in range
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }

    private boolean isValidBSTInterative(TreeNode root) {
        List<Integer> inOrderTraversal = inOrderTraversal(root);
        return isArraySorted(inOrderTraversal, 0);
    }

    private List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderHelper(root, result);
        return result;
    }

    private void inOrderHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inOrderHelper(root.left, result);
        result.add(root.val);
        inOrderHelper(root.right, result);
    }

    private boolean isArraySorted(List<Integer> inOrderList, int index) {
        if (index == inOrderList.size() - 1) {
            return true;
        }
        return inOrderList.get(index) < inOrderList.get(index + 1)
                && isArraySorted(inOrderList, index + 1);
    }
}
