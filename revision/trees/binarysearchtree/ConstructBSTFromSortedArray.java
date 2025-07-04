package revision.trees.binarysearchtree;

import revision.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBSTFromSortedArray {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        TreeNode root = null;
        Queue<NodeMeta> queue = new LinkedList<>();
        queue.offer(new NodeMeta(0, nums.length - 1, null, false));

        while (!queue.isEmpty()) {
            NodeMeta meta = queue.poll();
            int low = meta.low;
            int high = meta.high;
            TreeNode currentParent = meta.parent;

            if (low > high) continue;

            int mid = low + (high - low) / 2;
            TreeNode newNode = new TreeNode(nums[mid]);

            if (currentParent == null) {
                root = newNode;
            } else {
                if (meta.isLeft) {
                    currentParent.left = newNode;
                } else {
                    currentParent.right = newNode;
                }
            }

            queue.offer(new NodeMeta(low, mid - 1, newNode, true));
            queue.offer(new NodeMeta(mid + 1, high, newNode, false));
        }

        return root;
    }
}

class NodeMeta {
    int low, high;
    TreeNode parent;
    boolean isLeft;

    NodeMeta(int low, int high, TreeNode parent, boolean isLeft) {
        this.low = low;
        this.high = high;
        this.parent = parent;
        this.isLeft = isLeft;
    }
}
