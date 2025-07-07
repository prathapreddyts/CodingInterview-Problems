package revision.trees.interviewbit.traversals;



import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {
    public int[] inorderTraversal(TreeNode root) {
        return inOrderTraversalHelperIterative(root);
    }

    public int[] inOrderTraversalHelperIterative(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            inOrderList.add(currentNode.val);
            currentNode = currentNode.right;
        }
        int[] result = new int[inOrderList.size()];
        for (int i = 0; i < inOrderList.size(); i++) {
            result[i] = inOrderList.get(i);
        }
        return result;
    }

}
