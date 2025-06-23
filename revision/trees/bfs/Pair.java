package revision.trees.bfs;

import revision.trees.TreeNode;

public class Pair {
    TreeNode node;
    int verticalLevel;

    Pair(TreeNode node, int verticalLevel) {
        this.node = node;
        this.verticalLevel = verticalLevel;
    }
}
