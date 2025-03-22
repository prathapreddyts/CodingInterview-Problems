package trees.levelordertraversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLeftView {
    public List<Integer> leftViewOfTree(TreeNode root) {
        List<Integer> leftViewResult = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode polledNode = queue.poll();
                if (i == 0) {
                    leftViewResult.add(polledNode.val);
                }
                if (polledNode.left != null) {
                    queue.add(polledNode.left);
                }
                if (polledNode.right != null) {
                    queue.add(polledNode.right);
                }
            }
        }
        return leftViewResult;
    }



}
