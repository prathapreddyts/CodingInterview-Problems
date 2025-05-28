package arrays;

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

    public void reverse(int[] arr, int n) {
        int p1 = 0, p2 = n - 1;
        while (p1 < p2) {
            int tmp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = tmp;
            p1++;
            p2--;
        }
    }
}
