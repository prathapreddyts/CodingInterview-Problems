package revision.trees.treeconstruction;

import revision.trees.TreeNode;

import java.util.Stack;

public class ConstructTreeFromPostOrderInOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeIterativeWay(inorder, postorder);
    }

    public TreeNode buildTreeIterativeWay(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0) return null;

        int inIdx = inorder.length - 1;
        int postIdx = postorder.length - 1;

        TreeNode root = new TreeNode(postorder[postIdx--]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (postIdx >= 0) {
            TreeNode node = new TreeNode(postorder[postIdx--]);
            TreeNode parent = null;


            while (!stack.isEmpty() && stack.peek().data == inorder[inIdx]) {
                parent = stack.pop();
                inIdx--;
            }

            if (parent != null) {
                parent.left = node;
            } else if (!stack.isEmpty()) {
                stack.peek().right = node;
            }

            stack.push(node);
        }

        return root;
    }

}
