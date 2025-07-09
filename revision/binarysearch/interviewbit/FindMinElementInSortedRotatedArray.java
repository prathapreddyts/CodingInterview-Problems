package revision.binarysearch.interviewbit;

import java.util.List;

public class FindMinElementInSortedRotatedArray {
    public int findMin(final List<Integer> nums) {
        return findMinHelper(nums);
    }

    private int findMinHelper(List<Integer> nums) {
        int pivotIndex = findPivot(nums);
        if (pivotIndex < nums.size() - 1) {
            return nums.get(pivotIndex + 1);
        }
        return nums.get(0); // no rotation
    }

    private int findPivot(List<Integer> nums) {
        int start = 0;
        int end = nums.size() - 1;

        // If the array is not rotated
        if (nums.get(start) <= nums.get(end)) {
            return end;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // check if mid is pivot
            if (mid < end && nums.get(mid) > nums.get(mid + 1)) {
                return mid;
            }

            // check if mid-1 is pivot
            if (mid > start && nums.get(mid - 1) > nums.get(mid)) {
                return mid - 1;
            }

            // decide which side to go
            if (nums.get(start) <= nums.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

}
