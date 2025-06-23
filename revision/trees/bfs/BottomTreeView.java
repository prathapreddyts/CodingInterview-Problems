package revision.trees.bfs;

import revision.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BottomTreeView {
    public List<Integer> bottomView(TreeNode root) {
        return bottomViewHelper(root, new ArrayList<Integer>());
    }

    private List<Integer> bottomViewHelper(TreeNode root, ArrayList<Integer> bottomViewList) {
        return bottomViewList;
    }
}
