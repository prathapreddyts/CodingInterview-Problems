package revision.trees.binarysearchtree;

import revision.trees.TreeNode;

public class InsertionInBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insertIntoBSTIterativeHelper(root, val);
    }

    private TreeNode insertIntoBSTIterativeHelper(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        TreeNode current = root;
        TreeNode parent = null;
        while (current != null) {
            parent = current;
            if (val < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (val < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        return root;
    }

    private TreeNode insertIntoBSTRecursiveHelper(TreeNode root, int val) {
        TreeNode current = root;
        if (current == null) {
            return new TreeNode(val);
        }
        if (current.data > val) {
            current.left = insertIntoBSTRecursiveHelper(current.left, val);
        } else {
            current.right = insertIntoBSTRecursiveHelper(current.right, val);
        }
        return root;
    }
}
