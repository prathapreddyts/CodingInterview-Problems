package blind75;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        Queue<TreeNode> pLevelOrder = new LinkedList<>();
        Queue<TreeNode> qLevelOrder = new LinkedList<>();
        pLevelOrder.add(p);
        qLevelOrder.add(q);

        while (!pLevelOrder.isEmpty() && !qLevelOrder.isEmpty()) {
            TreeNode treePNode = pLevelOrder.poll();
            TreeNode treeQNode = qLevelOrder.poll();

            if (treePNode == null && treeQNode == null) {
                continue;
            }
            if (treePNode == null || treeQNode == null) {
                return false;
            }
            if (treePNode.val != treeQNode.val) {
                return false;
            }

            pLevelOrder.add(treePNode.left);
            qLevelOrder.add(treeQNode.left);

            pLevelOrder.add(treePNode.right);
            qLevelOrder.add(treeQNode.right);
        }

        return pLevelOrder.isEmpty() && qLevelOrder.isEmpty();
    }

}
