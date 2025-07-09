package revision.binarysearch.interviewbit;

public class SearchInBitonicArray {
    public int solve(int[] nums, int target) {
        int peak = findPeak(nums);
        int index = binarySearch(nums, target, 0, peak, true);
        if (index != -1) {
            return index;
        }
        return binarySearch(nums, target, peak + 1, nums.length - 1, false);
    }

    private int findPeak(int[] nums) {
        int start = 1, end = nums.length - 2;
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid; // Found peak
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid + 1; // go right
            } else {
                end = mid - 1; // go left
            }
        }
        return -1;
    }
    private int binarySearch(int[] nums, int target, int start, int end, boolean isAscending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;

            if (isAscending) {
                if (target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
