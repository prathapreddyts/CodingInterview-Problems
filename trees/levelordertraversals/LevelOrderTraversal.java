package trees.levelordertraversals;

import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {

    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode polledNode = queue.poll();
            result.add(polledNode.val);
            if (polledNode.left != null) {
                queue.add(polledNode.left);
            }
            if (polledNode.right != null) {
                queue.add(polledNode.right);
            }
        }
        return result;
    }


    public List<List<Integer>> levelByLevelOrder(TreeNode root) {
        List<List<Integer>> levelByLevelOrder = new ArrayList<>();
        if (root == null) {
            return levelByLevelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> innerLevelOrder = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode polledNode = queue.poll();
                innerLevelOrder.add(polledNode.val);

                if (polledNode.left != null) {
                    queue.add(polledNode.left);
                }
                if (polledNode.right != null) {
                    queue.add(polledNode.right);
                }
            }
            levelByLevelOrder.add(innerLevelOrder);
        }
        return levelByLevelOrder;
    }


}
