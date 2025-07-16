package interviewbitseries.trees.bsttraversals;

import trees.levelordertraversals.TreeNode;

import java.util.Stack;

public class ValidBSTFromPreOrder {
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode parent = stack.peek();
            TreeNode newNode = new TreeNode(preorder[i]);
            if (newNode.val < parent.val) {
                parent.left = newNode;
            } else {
                while (!stack.isEmpty() && newNode.val > stack.peek().val) {
                    parent = stack.pop();
                }
                parent.right = newNode;
            }
            stack.push(newNode);
        }
        return root;
    }
}
