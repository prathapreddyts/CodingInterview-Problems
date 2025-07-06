package revision.trees.treeconstruction;

import revision.trees.TreeNode;

import java.util.HashMap;

public class ConstructTreeFromInOrderAndPreOrder {
    int preStart = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return buildTreeHelper(0, inorder.length - 1, preorder, inOrderMap);
    }

    private TreeNode buildTreeHelper(int inStart, int inEnd, int[] preorder, HashMap<Integer, Integer> inOrderMap) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode rootNode = new TreeNode(preorder[preStart++]);
        int rootIndex = inOrderMap.get(rootNode.data);

        rootNode.left = buildTreeHelper(inStart, rootIndex - 1, preorder, inOrderMap);
        rootNode.right = buildTreeHelper(rootIndex + 1, inEnd, preorder, inOrderMap);

        return rootNode;
    }

}
