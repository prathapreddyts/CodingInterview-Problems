package revision.binarysearch;

public class FloorAndCeil {
    public int[] getFloorAndCeil(int[] nums, int target) {
        int[] result = {getFloorValue(nums, target), getCeilValue(nums, target)};
        return result;
    }

    private int getCeilValue(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return nums[mid];
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // after loop, start points to smallest number > target (ceil)
        if (start < nums.length) {
            return nums[start];
        } else {
            return -1; // no ceil exists
        }
    }

    private int getFloorValue(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return nums[mid];
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // after loop, end points to largest number < target (floor)
        if (end >= 0) {
            return nums[end];
        } else {
            return -1; // no floor exists
        }
    }

}
