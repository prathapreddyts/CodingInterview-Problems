package trees.binarySearchTree;

import trees.levelordertraversals.TreeNode;

public class InsertionNodeInBST {
    public TreeNode insertNode(TreeNode root, int k) {
        TreeNode temp = root;
        if (root == null) {
            return temp;
        }
        while (root != null) {
            if (k < root.val) {
                if (root.left != null) {
                    root = root.left;
                } else {
                    root.left = new TreeNode(k);
                    break;
                }
            } else {
                if (root.right != null) {
                    root = root.right;
                } else {
                    root.right = new TreeNode(k);
                    break;
                }
            }
        }
        return temp;
    }
}
