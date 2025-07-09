package revision.binarysearch.interviewbit;

public class SmallOrEqualCount {
    public int solve(int[] nums, int target) {
        return countLessThanOrEqual(nums, target);
    }

    private int countLessThanOrEqual(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] <= target) {
                ans = mid;          // store the current valid index
                start = mid + 1;    // try to find a larger valid index
            } else {
                end = mid - 1;
            }
        }

        return ans + 1; // count = index + 1
    }

}
