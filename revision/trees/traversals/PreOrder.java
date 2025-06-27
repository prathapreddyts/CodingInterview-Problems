package revision.trees.traversals;

import revision.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrder {
    public List<Integer> preorder(TreeNode root) {
        List<Integer>preOrderList=new ArrayList<>();
        preorderHelper(root,preOrderList);
        return preOrderList;
    }

    private void preorderHelper(TreeNode root, List<Integer> preOrderList) {
        if(root==null){
            return;
        }
        preOrderList.add(root.data);
        preorderHelper(root.left,preOrderList);
        preorderHelper(root.right,preOrderList);
    }

}
