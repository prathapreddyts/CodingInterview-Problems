package stacks.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nge[i] = -1;
        }
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                nge[stack.pop()] = arr[i];//Value based
            }
            stack.push(i);
        }
        return nge;
    }
    public int[] nextGreaterElementsCircular(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        for (int i = 0; i < n; i++) {
            nge[i] = -1;
        }
        Stack<Integer> stack = new Stack<>(); // Stores indices
        for (int i = 0; i < 2 * n; i++) {
            int curr = nums[i % n];
            while (!stack.isEmpty() && curr > nums[stack.peek()]) {
                nge[stack.pop()] = curr; // Update NGE for the popped index
            }
            if (i < n) stack.push(i); // Only push indices from the first pass
        }
        return nge;
    }
}
