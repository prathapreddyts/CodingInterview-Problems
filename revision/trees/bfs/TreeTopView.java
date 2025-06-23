package revision.trees.bfs;

import revision.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeTopView {
    public List<Integer> topView(TreeNode root) {
        return topViewHelper(root, new ArrayList<Integer>());

    }

    public List<Integer> topViewHelper(TreeNode root, ArrayList<Integer> topViewTreeList) {
        return topViewTreeList;
    }
}
