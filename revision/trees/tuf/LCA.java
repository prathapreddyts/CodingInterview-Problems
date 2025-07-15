package revision.trees.tuf;

public class LCA {
    public TreeNode lca(TreeNode root, int p, int q) {
        return lcaHelper(root, p, q);
    }

    private TreeNode lcaHelper(TreeNode root, int p, int q) {
        if (root == null) return null;

        int cur = root.data;

        if (cur < p && cur < q) {
            return lcaHelper(root.right, p, q);
        } else if (cur > p && cur > q) {
            return lcaHelper(root.left, p, q);
        } else {
            return root;
        }
    }

}
