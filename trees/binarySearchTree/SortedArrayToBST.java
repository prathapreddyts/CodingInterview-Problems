package trees.binarySearchTree;


import trees.levelordertraversals.TreeNode;

public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length - 1);
    }

    private static TreeNode constructBST(int[] nums, int left, int right) {
        if (left > right) return null; // Base case

        int mid = left + (right - left) / 2; // Middle element
        TreeNode root = new TreeNode(nums[mid]);

        root.left = constructBST(nums, left, mid - 1);// Left subtree
        root.right = constructBST(nums, mid + 1, right); // Right subtree

        return root;
    }

}

