package revision.binarysearch.interviewbit;

import java.util.ArrayList;

public class SearchInsertionPosition {
    public int searchInsert(ArrayList<Integer> nums, int target) {
        return searchInsertHelper(nums, target);
    }

    private int searchInsertHelper(ArrayList<Integer> nums, int target) {
        int start = 0;
        int end = nums.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums.get(mid) == target) {
                return mid;
            } else if (nums.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

}
