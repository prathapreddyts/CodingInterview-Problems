package blind75.easy;

import java.util.LinkedList;
import java.util.Queue;

public class IsSubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        while (!bfs.isEmpty()) {
            TreeNode current = bfs.poll();
            if (isSame(current, subRoot))
                return true;
            else {
                if(current!=null){
                    bfs.add(current.left);
                    bfs.add(current.right);
                }
            }
        }
        return false;
    }

    public boolean isSame(TreeNode tree, TreeNode subTree) {
        Queue<TreeNode> bfsQ = new LinkedList<>();

        bfsQ.add(tree);
        bfsQ.add(subTree);

        while (!bfsQ.isEmpty()) {
            TreeNode a = bfsQ.poll();
            TreeNode b = bfsQ.poll();
            if (a == null && b == null)
                continue;
            if (a == null || b == null)
                return false;

            if (a.val != b.val)
                return false;

            bfsQ.add(a.left);
            bfsQ.add(b.left);
            bfsQ.add(a.right);
            bfsQ.add(b.right);
        }

        return true;
    }
}
