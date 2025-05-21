package recursionbacktracking.recursion;

import java.util.ArrayList;

public class IsArraySorted {
    public boolean isSorted(ArrayList<Integer> nums) {
        return isSortedArrayHelper(0, nums);
    }

    public boolean isSortedArrayHelper(int index, ArrayList<Integer> nums) {
        // Base case: if we are at the last element or the array is empty/single element
        if (index >= nums.size() - 1) {
            return true;
        }
        return nums.get(index) <= nums.get(index + 1) && isSortedArrayHelper(index + 1, nums);
    }

}
