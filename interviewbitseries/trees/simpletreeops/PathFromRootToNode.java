package interviewbitseries.trees.simpletreeops;

import trees.levelordertraversals.TreeNode;

import java.util.*;

public class PathFromRootToNode {
    public int[] solve(TreeNode root, int val) {
        return pathfromRootToNodeHelper(root, val);
    }

    private int[] pathfromRootToNodeHelper(TreeNode root, int val) {
        TreeNode targetNode = findNode(root, val);
        Map<TreeNode, TreeNode> parentMap = buildTreeMap(root);
        ArrayList<Integer> path = new ArrayList<>();
        TreeNode current = targetNode;
        while (current != null) {
            path.add(current.val);
            current = parentMap.get(current);
        }
        int[] resultPath = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            resultPath[path.size() - 1 - i] = path.get(i);
        }
        return resultPath;
    }

    public Map<TreeNode, TreeNode> buildTreeMap(TreeNode root) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        parentMap.put(root, null);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll(); // FIX: Update current here
            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.add(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.add(current.right);
            }
        }
        return parentMap;
    }


    public TreeNode findNode(TreeNode root, int target) {
        TreeNode current = root;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(current);
        while (!nodeQueue.isEmpty()) {
            TreeNode peekNode = nodeQueue.peek();
            if (peekNode.val == target) {
                return peekNode;
            }
            if (peekNode.left != null) {
                nodeQueue.add(peekNode.left);
            }
            if (peekNode.right != null) {
                nodeQueue.add(peekNode.right);
            }
            nodeQueue.poll();
        }

        return null;
    }
}
