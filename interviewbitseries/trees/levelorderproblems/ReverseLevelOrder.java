package interviewbitseries.trees.levelorderproblems;

import trees.levelordertraversals.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrder {
    public int[] solve(TreeNode root) {
        return reverseLevelOrderHelper(root);
    }

    private int[] reverseLevelOrderHelper(TreeNode root) {
        if (root == null) return new int[0];

        List<List<Integer>> outerLevel = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // Add root to the queue

        while (!queue.isEmpty()) {
            List<Integer> innerLevel = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                innerLevel.add(currentNode.val);

                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }

            outerLevel.add(0, innerLevel); // Prepend to get reverse level order
        }

        // Flatten the list of lists into a single int[]
        List<Integer> resultList = new ArrayList<>();
        for (List<Integer> level : outerLevel) {
            resultList.addAll(level);
        }

        // Convert List<Integer> to int[]
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

}
