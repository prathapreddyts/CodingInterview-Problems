package revision.trees.bfs;

import revision.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CountTotalNodes {

    public int countNodes(TreeNode root) {
        return countNodesHelper(root);
    }

    public int countNodesHelper(TreeNode root) {
        int count = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode polledNode = nodeQueue.poll();
            count++;
            if (polledNode.right != null) {
                nodeQueue.add(polledNode.left);
            }
            if (polledNode.right != null) {
                nodeQueue.add(polledNode.right);
            }
        }
        return count;

    }
}
