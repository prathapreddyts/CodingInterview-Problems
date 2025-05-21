package recursionbacktracking.recursion;

public class ReverseArray {
    public int[] reverseArray(int[] nums) {
        reverseArrayHelper(0, nums.length - 1, nums);
        return nums;
    }

    public void reverseArrayHelper(int start, int end, int[] nums) {
        if (start >= end) {
            return;
        }
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        reverseArrayHelper(start + 1, end - 1, nums);
    }
}
