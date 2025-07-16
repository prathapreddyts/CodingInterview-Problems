package interviewbitseries.trees.lca;

import trees.levelordertraversals.TreeNode;

import java.util.*;

public class BSTLca {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorHelper(root, p, q);
    }

    private TreeNode lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = getParentMapBuild(root);
        Set<TreeNode> ancestors = new HashSet<>();

        // Step 1: Add all ancestors of p
        while (p != null) {
            ancestors.add(p);
            p = parentMap.get(p);
        }

        // Step 2: Traverse from q upwards until an ancestor of p is found
        while (!ancestors.contains(q)) {
            q = parentMap.get(q);
        }

        return q;
    }

    private Map<TreeNode, TreeNode> getParentMapBuild(TreeNode root) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parentMap.put(root, null);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }

        return parentMap;
    }
}

