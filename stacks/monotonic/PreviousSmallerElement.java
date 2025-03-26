package stacks.monotonic;

import java.util.*;

public class PreviousSmallerElement {
    public static int[] previousSmallerElement(int[] arr) {
        int[] pse = new int[arr.length];
        Arrays.fill(pse, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                pse[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        return pse;
    }

    public static int[] previousSmallerElementCircular(int[] arr) {
        int n = arr.length;
        int[] pse = new int[arr.length];
        Arrays.fill(pse, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int curIdx = i % n;
            while (!stack.isEmpty() && arr[curIdx] < arr[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                pse[curIdx] = arr[stack.peek()];
            }
            if (i < n) {
                stack.push(i);
            }

        }
        return pse;
    }
}
