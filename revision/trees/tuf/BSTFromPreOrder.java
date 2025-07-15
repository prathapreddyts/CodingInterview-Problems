package revision.trees.tuf;

import java.util.Stack;

public class BSTFromPreOrder {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            TreeNode parent = stack.peek();

            // If value < parent → it's the left child
            if (node.data < parent.data) {
                parent.left = node;
            } else {
                // Pop until we find the correct parent
                while (!stack.isEmpty() && node.data > stack.peek().data) {
                    parent = stack.pop();
                }
                parent.right = node;
            }

            stack.push(node); // Push current node as new potential parent
        }

        return root;
    }
}
