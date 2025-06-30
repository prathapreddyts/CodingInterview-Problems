package revision.trees.binarysearchtree;

import com.sun.source.tree.Tree;
import revision.trees.TreeNode;

import java.util.Stack;

public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        return searchBSTRecursiveHelper(root, val);
    }

    public TreeNode searchBSTRecursiveHelper(TreeNode root, int val) {
        TreeNode current = root;
        if (current == null) {
            return null;
        }
        if (current.data == val) {
            return current;
        } else if (current.data < val) {
            return searchBSTRecursiveHelper(current.right, val);
        } else {
            return searchBSTRecursiveHelper(current.left, val);
        }
    }

    public TreeNode searchBSTIterativeHelper(TreeNode root, int val) {
        TreeNode current = root;
        if (root == null) {
            return null;
        }
        while (current != null) {
            if (current.data == val) {
                return current;
            } else if (current.data > val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }
    public TreeNode searchBSTInOrderHelper(TreeNode root, int val) {
        TreeNode current = root;
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(current);
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            TreeNode popped = stack.pop();
            if (popped.data == val) {
                return popped;
            }
            current = popped.right;
        }
        return null;
    }
}
