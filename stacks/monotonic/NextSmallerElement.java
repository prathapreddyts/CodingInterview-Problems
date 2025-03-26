package stacks.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static int[] nextSmallerElement(int[] arr) {
        int[] nse = new int[arr.length];
        Arrays.fill(nse, -1);
        Stack<Integer> stack = new Stack<>(); // Stores indices

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                nse[stack.pop()] = arr[i]; // Update NSE for popped index
            }
            stack.push(i); // Push current index
        }
        return nse;
    }

    public static int[] nextSmallerElementCircular(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Arrays.fill(nse, -1);
        Stack<Integer> stack = new Stack<>(); // Stores indices

        for (int i = 0; i < 2 * n; i++) {
            int currIdx = i % n; // Wrap index without modifying loop counter
            while (!stack.isEmpty() && arr[currIdx] < arr[stack.peek()]) {
                nse[stack.pop()] = arr[currIdx]; // Update NSE
            }
            if (i < n) stack.push(currIdx); // Push only in first pass
        }
        return nse;
    }
}
