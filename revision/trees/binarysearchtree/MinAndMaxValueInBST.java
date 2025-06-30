package revision.trees.binarysearchtree;

import revision.trees.TreeNode;

public class MinAndMaxValueInBST {

    // Iterative minimum
    public int findMinimumValue(TreeNode root) {
        if (root == null) return -1;
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    // Recursive minimum (returns value)
    public int findMinValue(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null) return root.data;
        return findMinValue(root.left);
    }

    // Recursive minimum (void version using array)
    public void findMinimumValue(TreeNode root, int[] min) {
        if (root == null) return;
        if (root.left == null) {
            min[0] = root.data;
            return;
        }
        findMinimumValue(root.left, min);
    }

    // Iterative maximum
    public int findMaximumValue(TreeNode root) {
        if (root == null) return -1;
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    // Recursive maximum (returns value)
    public int findMaxValue(TreeNode root) {
        if (root == null) return -1;
        if (root.right == null) return root.data;
        return findMaxValue(root.right);
    }

    // Recursive maximum (void version using array)
    public void findMaximumValue(TreeNode root, int[] max) {
        if (root == null) return;
        if (root.right == null) {
            max[0] = root.data;
            return;
        }
        findMaximumValue(root.right, max);
    }

}
