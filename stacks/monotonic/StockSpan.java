package stacks.monotonic;

import java.util.Stack;


public class StockSpan {

    public int[] stockSpan(int[] arr, int n) {
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop(); // Pop smaller or equal prices
            }
            if (stack.isEmpty()) {
                span[i] = i + 1;  // No previous greater element → span includes all days up to i
            } else {
                span[i] = i - stack.peek();  // Distance from the last greater price day
            }
            stack.push(i);  // Push current index for future comparisons
        }

        return span;
    }


}
