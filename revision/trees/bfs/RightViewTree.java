package revision.trees.bfs;

import revision.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewTree {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> rightSideViewList = new ArrayList<>();
        return rightSideViewHelper(root,rightSideViewList);
    }

    public List<Integer> rightSideViewHelper(TreeNode root, ArrayList<Integer> rightSideViewList) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode lastNode = null;
        if (root != null) {
            nodeQueue.add(root);
            lastNode = root;
        }
        while (!nodeQueue.isEmpty()) {
            TreeNode peekNode = nodeQueue.peek();
            if (peekNode.left != null) {
                nodeQueue.add(peekNode.left);
            }
            if (peekNode.right != null) {
                nodeQueue.add(peekNode.right);
            }
            if (peekNode == lastNode) {
                rightSideViewList.add(peekNode.data);
                nodeQueue.poll();
                lastNode = ((LinkedList<TreeNode>) nodeQueue).peekLast();
            } else {
                nodeQueue.poll();
            }
        }
        return rightSideViewList;
    }

}
