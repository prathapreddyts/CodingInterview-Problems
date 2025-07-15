package revision.trees.tuf;

import java.util.*;

public class TreePathUtils {

    private Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    // Step 1: Build parent map (DFS or BFS)
    private void buildParentMap(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        parentMap.put(root, null);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }

    // Utility to find the TreeNode with given value
    private TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.data == val) return root;
        TreeNode left = findNode(root.left, val);
        if (left != null) return left;
        return findNode(root.right, val);
    }

    // ✅ 1. Path from node to root
    public List<Integer> pathToRoot(TreeNode root, int val) {
        buildParentMap(root);
        TreeNode node = findNode(root, val);
        List<Integer> path = new ArrayList<>();

        while (node != null) {
            path.add(node.data);
            node = parentMap.get(node);
        }
        return path; // from node to root
    }

    // ✅ 2. Path from root to node
    public List<Integer> pathFromRoot(TreeNode root, int val) {
        List<Integer> path = pathToRoot(root, val);
        Collections.reverse(path);
        return path; // root to node
    }

    // ✅ 3. Path from nodeP to nodeQ
    public List<Integer> pathBetweenNodes(TreeNode root, int p, int q) {
        buildParentMap(root);
        TreeNode nodeP = findNode(root, p);
        TreeNode nodeQ = findNode(root, q);
        if (nodeP == null || nodeQ == null) return Collections.emptyList();

        // Step A: Record ancestors of nodeP
        Set<TreeNode> ancestors = new HashSet<>();
        TreeNode temp = nodeP;
        while (temp != null) {
            ancestors.add(temp);
            temp = parentMap.get(temp);
        }

        // Step B: Move up from nodeQ until we find LCA
        TreeNode lca = nodeQ;
        while (!ancestors.contains(lca)) {
            lca = parentMap.get(lca);
        }

        // Step C: Path from nodeP to LCA
        List<Integer> pToLca = new ArrayList<>();
        temp = nodeP;
        while (temp != lca) {
            pToLca.add(temp.data);
            temp = parentMap.get(temp);
        }
        pToLca.add(lca.data); // include LCA

        // Step D: Path from nodeQ to LCA (excluding LCA), then reverse
        List<Integer> qToLca = new ArrayList<>();
        temp = nodeQ;
        while (temp != lca) {
            qToLca.add(temp.data);
            temp = parentMap.get(temp);
        }
        Collections.reverse(qToLca);

        // Step E: Combine
        pToLca.addAll(qToLca);
        return pToLca;
    }

    // ✅ 4. Distance between two nodes
    public int distanceBetweenNodes(TreeNode root, int p, int q) {
        buildParentMap(root);
        TreeNode nodeP = findNode(root, p);
        TreeNode nodeQ = findNode(root, q);
        if (nodeP == null || nodeQ == null) return -1;

        Set<TreeNode> ancestors = new HashSet<>();
        TreeNode temp = nodeP;
        int distP = 0;
        while (temp != null) {
            ancestors.add(temp);
            temp = parentMap.get(temp);
        }

        temp = nodeQ;
        int distQ = 0;
        while (!ancestors.contains(temp)) {
            temp = parentMap.get(temp);
            distQ++;
        }

        // Now temp is LCA, find distance from P to LCA
        TreeNode lca = temp;
        temp = nodeP;
        while (temp != lca) {
            distP++;
            temp = parentMap.get(temp);
        }

        return distP + distQ;
    }
}
