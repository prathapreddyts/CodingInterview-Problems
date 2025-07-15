package revision.trees.tuf;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementInBST {
    public List<Integer> kLargesSmall(TreeNode root, int k) {
        return Arrays.asList(findKthSmallest(root, k), findKthLargest(root, k));
    }

    // Find kth smallest using inorder traversal
    private int findKthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            k--;
            if (k == 0) return current.data;

            current = current.right;
        }

        return -1; // k is out of range
    }

    // Find kth largest using reverse inorder traversal
    private int findKthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.right;
            }

            current = stack.pop();
            k--;
            if (k == 0) {
                return current.data;
            }

            current = current.left;
        }

        return -1; // k is out of range
    }
}

