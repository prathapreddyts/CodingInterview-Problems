package revision.trees.iterativetraversals;

import revision.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderIterative {
    public List<Integer> postorder(TreeNode root) {
        List<Integer> postOrderList = new ArrayList<>();
        postOrderHelper(root, postOrderList);
        return postOrderList;
    }

    public void postOrderHelper(TreeNode root, List<Integer> postOrderList) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    current = peekNode.right;
                } else {
                    postOrderList.add(peekNode.data);
                    lastVisited = stack.pop();
                }
            }
        }
    }
}
