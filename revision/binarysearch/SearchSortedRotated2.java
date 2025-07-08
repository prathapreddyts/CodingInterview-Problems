package revision.binarysearch;

import java.util.ArrayList;

public class SearchSortedRotated2 {
    public boolean searchInARotatedSortedArrayII(ArrayList<Integer> nums, int k) {
        int[] num = new int[nums.size()];  // Correct array initialization
        for (int i = 0; i < nums.size(); i++) {  // Correct loop bounds
            num[i] = nums.get(i);  // Copy elements from the ArrayList to the array
        }
        return search(num, k);  // Call the search function
    }

    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[low] == nums[mid] && nums[high] == nums[mid]) {
                low++;
                high--;
            } else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;

                } else {
                    low = mid + 1;

                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;

                } else {
                    high = mid - 1;

                }
            }
        }
        return false;

    }
}
