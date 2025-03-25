package trees.binarySearchTree;

import trees.levelordertraversals.TreeNode;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int k) {
        if (root == null) return null;

        if (root.val > k) {
            root.left = deleteNode(root.left, k);
        } else if (root.val < k) {
            root.right = deleteNode(root.right, k);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public class BST {

        public TreeNode deleteNode(TreeNode root, int k) {
            TreeNode current = root, parent = null;
            while (current != null && current.val != k) {
                parent = current;
                if (k < current.val) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            if (current == null) {
                return root;
            }
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
                TreeNode child = (current.left != null) ? current.left : current.right;
                if (parent == null) {
                    return child;
                }
                if (parent.left == current) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            } else {
                TreeNode successorParent = current;
                TreeNode successor = current.right;
                while (successor.left != null) {
                    successorParent = successor;
                    successor = successor.left;
                }
                current.val = successor.val;
                if (successorParent.left == successor) {
                    successorParent.left = successor.right;
                } else {
                    successorParent.right = successor.right;
                }
            }

            return root;
        }
    }

}
