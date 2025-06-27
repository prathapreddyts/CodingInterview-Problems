package revision.trees.traversals;

import revision.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrder {


    public List<Integer> inorder(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        preorderHelper(root, inOrderList);
        return inOrderList;
    }

    private void preorderHelper(TreeNode root, List<Integer> inOrderList) {
        if (root == null) {
            return;
        }

        preorderHelper(root.left, inOrderList);
        inOrderList.add(root.data);
        preorderHelper(root.right, inOrderList);
    }
}
