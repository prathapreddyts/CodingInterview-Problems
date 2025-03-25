package trees.binarySearchTree;

import trees.levelordertraversals.TreeNode;

public class MaxAndMinElementInBST {
    public TreeNode maxElement(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
    public TreeNode minElement(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
