package interviewbitseries.trees.levelorderproblems;

import interviewbitseries.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfTree {
    public int[] solve(TreeNode root) {
        return rightViewOfTree(root);
    }

    private int[] rightViewOfTree(TreeNode root) {
        int index = 0;
        List<Integer> rightViewList = new ArrayList<>();
        TreeNode current = root;
        TreeNode firstNode = null;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(current);
            firstNode = current;
        }
        while (!queue.isEmpty()) {
            TreeNode peekNode = queue.peek();
            if (peekNode.left != null) {
                queue.add(peekNode.left);
            }
            if (peekNode.right != null) {
                queue.add(peekNode.right);
            }
            if (peekNode == firstNode) {
                rightViewList.add(peekNode.val);
                queue.poll();
                firstNode = ((LinkedList<TreeNode>) queue).peekLast();
            } else {
                queue.poll();
            }
        }
        int[] result = new int[rightViewList.size()];
        for (int i : rightViewList) {
            result[index] = i;
            index++;
        }
        return result;
    }
}
