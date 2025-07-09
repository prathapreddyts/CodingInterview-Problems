package revision.binarysearch.interviewbit;

public class CountElementOccurence {

    public int findCount(final int[] nums, int target) {
        return findCountHelper(nums, target);
    }

    private int findCountHelper(int[] nums, int target) {
        int leftIndex = getStartingIndex(nums, target);
        int rightIndex = getEndIndex(nums, target);
        if (leftIndex == -1 || rightIndex == -1) {
            return 0;
        }
        return rightIndex - leftIndex + 1;
    }

    private int getStartingIndex(int[] nums, int target) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1; // move left
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private int getEndIndex(int[] nums, int target) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                start = mid + 1; // move right
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}



