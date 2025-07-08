package revision.binarysearch;

public class SingleElement {
    public int singleNonDuplicate(int[] nums) {
        return singleNonDuplicateHelper(nums);
    }

    public int singleNonDuplicateHelper(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Make mid even for comparison
            if (mid % 2 == 1) {
                mid--;
            }

            // If pair is valid → move right
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }

        return nums[left]; // Single element found
    }

}
