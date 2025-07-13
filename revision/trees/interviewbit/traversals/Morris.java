package revision.trees.interviewbit.traversals;

import java.util.ArrayList;
import java.util.List;

public class Morris {
    public int[] inorderTraversal(TreeNode root) {
        return morrisInorderTraversal(root);
    }

    private int[] morrisInorderTraversal(TreeNode root) {
        List<Integer> dataList = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                dataList.add(current.val);
                current = current.right;
            } else {
                TreeNode tempNode = current.left;
                while (tempNode.right != null && tempNode.right != current) {
                    tempNode = tempNode.right;
                }
                if (tempNode.right == null) {
                    tempNode.right = current;
                    current = current.left;
                } else {
                    tempNode.right = null;
                    dataList.add(current.val);
                    current = current.right;
                }
            }
        }
        int[] result = new int[dataList.size()];
        for(int i=0;i<dataList.size();i++){
            result[i]=dataList.get(i);
        }

        return result;
    }
}
