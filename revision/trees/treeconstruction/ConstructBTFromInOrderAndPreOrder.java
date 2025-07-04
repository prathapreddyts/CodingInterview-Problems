package revision.trees.treeconstruction;

import revision.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConstructBTFromInOrderAndPreOrder {
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < preOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }
        return buildTreeHelper(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, inOrderMap);
    }

    private TreeNode buildTreeHelper(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> inOrderMap) {
        if ((preStart > preEnd) || (inStart > inEnd)) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        int inOrderIndex = inOrderMap.get(root.data);
        int numsLeft = inOrderIndex - inStart;
        root.left = buildTreeHelper(preOrder, preStart + 1, preStart + numsLeft, inOrder, inStart, inOrderIndex - 1, inOrderMap);
        root.right = buildTreeHelper(preOrder, preStart + numsLeft + 1, preEnd, inOrder, inOrderIndex + 1, inEnd, inOrderMap);

        return root;
    }
    public TreeNode buildTreeIterative(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            TreeNode parent = stack.peek();
            if (inorderMap.get(node.data) < inorderMap.get(parent.data)) {
                parent.left = node;
            } else {
                while (!stack.isEmpty() && inorderMap.get(node.data) > inorderMap.get(stack.peek().data)) {
                    parent = stack.pop();
                }
                parent.right = node;
            }

            stack.push(node);
        }

        return root;
    }
}
