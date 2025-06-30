package revision.trees.binarysearchtree;

import revision.trees.TreeNode;

public class DeletionOfNode {
    public TreeNode deleteLeafNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        TreeNode current = root;
        TreeNode parent = null;
        boolean targetFound = false;

        while (current != null) {
            if (val < current.data) {
                parent = current;
                current = current.left;
            } else if (val > current.data) {
                parent = current;
                current = current.right;
            } else {
                targetFound = true;
                break;
            }
        }
        if (targetFound) {
            if (current != null && current.left == null && current.right == null) {
                if (parent == null) {
                    return null;
                } else if (parent.left == current) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
        return root;
    }

    public TreeNode deleteNodeIfLeafOrOneChild(TreeNode root, int val) {
        if (root == null) return null;

        TreeNode current = root;
        TreeNode parent = null;

        while (current != null) {
            if (val < current.data) {
                parent = current;
                current = current.left;
            } else if (val > current.data) {
                parent = current;
                current = current.right;
            } else {
                if (current.left == null && current.right == null) {
                    if (parent == null) {
                        return null;
                    }
                    if (parent.left == current) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else if (current.left == null || current.right == null) {
                    TreeNode child;
                    if (current.left != null) {
                        child = current.left;
                    } else {
                        child = current.right;
                    }

                    if (parent == null) {
                        return child;
                    }
                    if (parent.left == current) {
                        parent.left = child;
                    } else {
                        parent.right = child;
                    }
                }
                break;
            }
        }
        return root;
    }


}
