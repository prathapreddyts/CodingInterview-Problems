package interviewbitseries.trees.roottoleaf;

import interviewbitseries.trees.TreeNode;

import java.util.*;

public class RootToLeafAllPaths {
    public static List<List<Integer>> findPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        parentMap.put(root, null);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.left == null && node.right == null) {
                List<Integer> path = new ArrayList<>();
                TreeNode current = node;
                while (current != null) {
                    path.add(current.val);
                    current = parentMap.get(current);
                }
                Collections.reverse(path);
                result.add(path);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                stack.push(node.right);
            }

            if (node.left != null) {
                parentMap.put(node.left, node);
                stack.push(node.left);
            }
        }

        return result;
    }
}
