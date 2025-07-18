package revision.trees.bfs;

import revision.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewTree {
    public List<Integer> leftSideView(TreeNode root) {
        ArrayList<Integer> leftSideViewList = new ArrayList<>();
        return leftSideViewHelper(root, leftSideViewList);
    }

    private List<Integer> leftSideViewHelper(TreeNode root, ArrayList<Integer> leftSideViewList) {
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        TreeNode firstNode = null;

        if (root != null) {
            nodeQueue.add(root);
            firstNode = root;
        }

        while (!nodeQueue.isEmpty()) {
            TreeNode peekNode = nodeQueue.peek();

            if (peekNode.left != null) {
                nodeQueue.add(peekNode.left);
            }

            if (peekNode.right != null) {
                nodeQueue.add(peekNode.right);
            }

            if (peekNode == firstNode) {
                leftSideViewList.add(peekNode.data);
                nodeQueue.poll();
                if (!nodeQueue.isEmpty()) {
                    firstNode = ((LinkedList<TreeNode>) nodeQueue).getFirst();
                }
            } else {
                nodeQueue.poll();
            }
        }

        return leftSideViewList;
    }

    public void leftViewOfTree(TreeNode root) {
        TreeNode current = root;
        TreeNode firstNode = null;
        Queue<TreeNode> queue = new LinkedList<>();
        if (current != null) {
            queue.add(current);
            firstNode = current;
        }
        while (!queue.isEmpty()) {
            TreeNode peekNode = queue.peek();
            if (peekNode.left != null) {
                queue.add(peekNode.left);
            }
            if (peekNode.right != null) {
                queue.add(peekNode.right);
            }
            if (peekNode == firstNode) {
                System.out.println(peekNode.data);
                queue.poll();
                if (!queue.isEmpty()) {
                    firstNode = ((LinkedList<TreeNode>) queue).getFirst();
                }
            } else {
                queue.poll();
            }

        }
    }

}
