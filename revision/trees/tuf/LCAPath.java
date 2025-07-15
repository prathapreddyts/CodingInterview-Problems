package revision.trees.tuf;

import java.util.*;

public class LCAPath {
    public List<Integer> getPathBetween(TreeNode root, int p, int q) {
        TreeNode nodeP = findNode(root, p);
        TreeNode nodeQ = findNode(root, q);

        if (nodeP == null || nodeQ == null) return Collections.emptyList();

        // Step 1: Build parent map
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

        // Step 2: Find LCA
        Set<TreeNode> ancestors = new HashSet<>();
        TreeNode temp = nodeP;
        while (temp != null) {
            ancestors.add(temp);
            temp = parentMap.get(temp);
        }

        TreeNode lca = nodeQ;
        while (!ancestors.contains(lca)) {
            lca = parentMap.get(lca);
        }

        // Step 3: Path from p to LCA
        List<Integer> path = new ArrayList<>();
        temp = nodeP;
        while (temp != lca) {
            path.add(temp.data);
            temp = parentMap.get(temp);
        }
        path.add(lca.data); // Add LCA

        // Step 4: Path from q to LCA (excluding LCA), then reverse
        List<Integer> qToLCA = new ArrayList<>();
        temp = nodeQ;
        while (temp != lca) {
            qToLCA.add(temp.data);
            temp = parentMap.get(temp);
        }
        Collections.reverse(qToLCA);
        path.addAll(qToLCA);
        return path;
    }

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
