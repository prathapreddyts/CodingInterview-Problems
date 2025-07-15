package revision.trees.tuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloorAndCeilInBST {
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        int ceil = ceilHelper(root, key);
        int floor = floorHelper(root, key);
        return Arrays.asList(ceil, floor);
    }

    private int floorHelper(TreeNode root, int key) {
        int floor = -1;
        TreeNode current = root;
        while (current != null) {
            if (current.data == key) {
                floor = current.data;
                return floor;
            } else if (current.data < key) {
                floor = current.data;
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return floor;
    }

    private int ceilHelper(TreeNode root, int key) {
        TreeNode current = root;
        int ceil = -1;

        while (current != null) {
            if (current.data == key) {
                return current.data;
            } else if (key < current.data) {
                ceil = current.data;
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return ceil;
    }

}
