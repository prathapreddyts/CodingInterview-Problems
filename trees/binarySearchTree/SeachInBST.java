package trees.binarySearchTree;

import trees.levelordertraversals.TreeNode;

public class SeachInBST {
    public boolean searchNodeInBST(TreeNode root, int target) {
        while (root != null) {
            if (root == null) {
                return false;
            }
            if (root.val == target) {
                return true;
            }
            if (root.val < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return false;

    }
}
