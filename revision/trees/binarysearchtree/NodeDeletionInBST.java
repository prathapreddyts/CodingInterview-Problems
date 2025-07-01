package revision.trees.binarysearchtree;

import revision.trees.TreeNode;

public class NodeDeletionInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        return searchForGivenNode(root, key);
    }

    public TreeNode searchForGivenNode(TreeNode root, int val) {
        TreeNode current = root;
        TreeNode parent = null;
        while (current != null && current.data != val) {
            parent = current;
            if (val < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null){
            return root;
        }
        if (current.left != null && current.right != null) {
            TreeNode successorParent = current;
            TreeNode successor = current.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            current.data = successor.data;
            current = successor;
            parent = successorParent;
        }
        TreeNode child = (current.left != null) ? current.left : current.right;
        if (parent == null) {
            return child;
        }

        if (parent.left == current) {
            parent.left = child;
        } else {
            parent.right = child;
        }

        return root;
    }

}
