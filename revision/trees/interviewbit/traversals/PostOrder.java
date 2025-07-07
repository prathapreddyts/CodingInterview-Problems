package revision.trees.interviewbit.traversals;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrder {
    public int[] postorderTraversal(TreeNode root) {
        return postorderTraversalHelperIterative(root);
    }

    private int[] postorderTraversalHelperIterative(TreeNode root) {
        ArrayList<Integer> postOrderList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode peekNode = stack.peek();
            if (peekNode.right != null && lastVisited != peekNode.right) {
                current = peekNode.right;
            } else {

                postOrderList.add(peekNode.val);
                lastVisited = stack.pop();
            }
        }
        int[] result = new int[postOrderList.size()];
        for (int i = 0; i < postOrderList.size(); i++) {
            result[i] = postOrderList.get(i);
        }
        return result;
    }

}
