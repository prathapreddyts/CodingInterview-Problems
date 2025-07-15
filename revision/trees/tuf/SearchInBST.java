package revision.trees.tuf;


public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        return searchBSTHelper(root, val);
    }

    private TreeNode searchBSTHelper(TreeNode root, int val) {
        TreeNode current = root;
        while (current != null) {
            if (current.data == val) {
                return current;
            } else if (current.data > val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }
}


