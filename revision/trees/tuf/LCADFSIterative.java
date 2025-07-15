package revision.trees.tuf;

import java.util.*;


public class LCADFSIterative {

    // ✅ Main method to find LCA
    public TreeNode lcaDFS(TreeNode root, int p, int q) {
        if (root == null) return null;

        // Find the actual TreeNode objects for values p and q
        TreeNode nodeP = findNode(root, p);
        TreeNode nodeQ = findNode(root, q);

        if (nodeP == null || nodeQ == null) return null; // one or both not found

        // Step 1: Build parent map using DFS
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        parentMap.put(root, null);
        stack.push(root);

        while (!parentMap.containsKey(nodeP) || !parentMap.containsKey(nodeQ)) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                parentMap.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Step 2: Store ancestors of nodeP in a set
        Set<TreeNode> ancestors = new HashSet<>();
        TreeNode current = nodeP;
        while (current != null) {
            ancestors.add(current);
            current = parentMap.get(current);
        }

        // Step 3: Go up from nodeQ until we hit an ancestor of nodeP
        current = nodeQ;
        while (!ancestors.contains(current)) {
            current = parentMap.get(current);
        }

        return current; // Lowest Common Ancestor
    }

    // ✅ Iterative findNode to get actual TreeNode instance by value
    private TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.data == val) {
                return current;
            }

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return null; // value not found in tree
    }
}
