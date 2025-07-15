package revision.trees.tuf;

public class IsBST {
    public boolean isBST(TreeNode root) {
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTHelper(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if (root.data >= maxValue || root.data <= minValue) {
            return false;
        }
        return isBSTHelper(root.left, minValue, root.data) &&
                isBSTHelper(root.right, root.data, maxValue);
    }
}
