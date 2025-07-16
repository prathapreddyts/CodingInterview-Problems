package interviewbitseries.trees.levelorderproblems;

import trees.levelordertraversals.TreeNode;

import java.util.*;

public class ZigZagLevelOrder {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        int level = 1;
        while (!queue.isEmpty()) {
            ArrayList<Integer> innerLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                innerLevel.add(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            if (level % 2 == 1) {
                ans.add(innerLevel);
                level++;
            } else {
                Collections.reverse(innerLevel);
                ans.add(innerLevel);
                level++;
            }
        }
        return ans;
    }
}
