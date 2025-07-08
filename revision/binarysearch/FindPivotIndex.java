package revision.binarysearch;

import java.util.ArrayList;

public class FindPivotIndex {
    public int findKRotation(ArrayList<Integer> arr) {
        int max = pivotIndex(arr);
        if (max < arr.size() - 1) {
            return max+1;
        }
        return 0;
    }
    public int findMin(ArrayList<Integer> arr) {
        int max = pivotIndex(arr);
        if (max < arr.size() - 1) {
            return arr.get(max+1);
        }
        return arr.get(0);
    }

    public int pivotIndex(ArrayList<Integer> arr) {
        int[] nums = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            nums[i] = arr.get(i);
        }
        return pivotIndexHelper(nums);
    }

    private int pivotIndexHelper(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (nums[start] <= nums[end]) {
            return end;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            if (nums[mid] >= nums[start]) {
                start = mid + 1;  // Left part is sorted ⇒ pivot is in the right (unsorted)
            } else {
                end = mid - 1;    // Right part is sorted ⇒ pivot is in the left (unsorted)
            }
        }
        return -1;
    }


}
