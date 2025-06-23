package revision.trees.bfs;

import revision.trees.TreeNode;

public class Tuple {
    public TreeNode node;
    public int vertical; // vertical
    public int level; // level

    Tuple(TreeNode node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}
