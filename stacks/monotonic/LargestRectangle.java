package stacks.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangle {

    public int largestRectangleArea(int[] heights) {
        int area=0;
        int[] nse = nextSmallerElement(heights);
        int[] pse = previousSmallerElement(heights);
        for(int i=0;i<heights.length;i++){
            int base=nse[i]-pse[i]-1;
            int height=heights[i];
            area=Math.max(area,base*height);
        }

        return area;

    }
    public int[] nextSmallerElement(int[] arr) {
        int[] nse = new int[arr.length];
        Arrays.fill(nse, arr.length); // Initialize to arr.length instead of -1
        Stack<Integer> stack = new Stack<>(); // Stores indices

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                nse[stack.pop()] = i; // Update NSE for popped index
            }
            stack.push(i); // Push current index
        }
        return nse;
    }

    public  int[] previousSmallerElement(int[] arr) {
        int[] pse = new int[arr.length];
        Arrays.fill(pse, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        return pse;
    }
}
