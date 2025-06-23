package revision.trees.bfs;

import revision.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderResult = new ArrayList<>();
        return levelOrderHelper(root, levelOrderResult);
    }

    public List<List<Integer>> levelOrderHelper(TreeNode root, List<List<Integer>> levelOrderResult) {
        if (root == null) {
            return levelOrderResult;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        if (root != null) {
            nodeQueue.add(root);
        }
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            List<Integer> innerLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode polledNode = nodeQueue.poll();
                innerLevel.add(polledNode.data);
                if (polledNode.left != null) {
                    nodeQueue.add(polledNode.left);
                }
                if (polledNode.right != null) {
                    nodeQueue.add(polledNode.right);
                }
            }
            levelOrderResult.add(innerLevel);

        }
        return levelOrderResult;

    }
}
