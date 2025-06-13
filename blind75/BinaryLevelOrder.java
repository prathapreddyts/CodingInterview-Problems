package blind75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> levelOrderQueue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        if (root != null) {
            levelOrderQueue.add(root);
        }
        while (!levelOrderQueue.isEmpty()) {
            int size = levelOrderQueue.size();
            List<Integer> innerLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode polledNode = levelOrderQueue.poll();
                innerLevel.add(polledNode.val);
                if(polledNode.left!=null){
                    levelOrderQueue.add(polledNode.left);
                }
                if(polledNode.right!=null){
                    levelOrderQueue.add(polledNode.right);
                }
            }
            result.add(innerLevel);
        }
        return result;

    }
}
