package revision.trees.bfs;

import revision.trees.TreeNode;

public class Pair {
    TreeNode node;
    int verticalLevel;
    int level;

    Pair(TreeNode node, int verticalLevel, int level) {
        this.node = node;
        this.verticalLevel = verticalLevel;
        this.level = level;
    }
}
