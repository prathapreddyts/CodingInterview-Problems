package revision.trees.bfs;

import revision.trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BoundaryTraversal {

    public List<Integer> boundary(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Add root
        result.add(root.data);

        // If root is a leaf, return early
        if (isLeaf(root)) return result;

        // Traverse left boundary (excluding leaf)
        traverseLeftBoundary(root.left, result);

        // Traverse all leaves (left to right)
        traverseLeaves(root, result);

        // Traverse right boundary (excluding leaf, in reverse)
        traverseRightBoundary(root.right, result);

        return result;
    }

    // Helper to check if a node is a leaf
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    // Traverse left boundary using BFS-like logic
    private void traverseLeftBoundary(TreeNode node, List<Integer> result) {
        while (node != null && !isLeaf(node)) {
            result.add(node.data);
            // Prefer left child, else right child
            node = node.left != null ? node.left : node.right;
        }
    }

    // Traverse all leaf nodes left to right
    private void traverseLeaves(TreeNode node, List<Integer> result) {
        if (node == null) return;
        if (isLeaf(node)) {
            result.add(node.data);
            return;
        }
        traverseLeaves(node.left, result);
        traverseLeaves(node.right, result);
    }

    // Traverse right boundary using BFS-like logic in reverse order
    private void traverseRightBoundary(TreeNode node, List<Integer> result) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (node != null && !isLeaf(node)) {
            stack.push(node.data);
            // Prefer right child, else left child
            node = node.right != null ? node.right : node.left;
        }
        // Add nodes in reverse order
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }
}
