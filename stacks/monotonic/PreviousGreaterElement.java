package stacks.monotonic;

import java.util.Stack;

public class PreviousGreaterElement {

    public static int[] previousGreaterElement(int arr[]) {
        int[] pge = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pge[i] = -1;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop(); // Pop indices of elements <= current
            }
            if (!stack.isEmpty()) {
                pge[i] = arr[stack.peek()]; // Assign the **element**, not index
                //pge[i]=stack.peek();//Index based
            }
            stack.push(i); // Push current index
        }

        return pge;
    }

    public static int[] previousGreaterElementCircular(int arr[]) {
        int n = arr.length;
        int[] pge = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pge[i] = -1;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int currIdx = i % n;
            while (!stack.isEmpty() && arr[currIdx] > arr[stack.peek()]) {
                stack.pop(); // Pop indices of elements <= current
            }
            if (!stack.isEmpty()) {
                pge[currIdx] = arr[stack.peek()]; // Assign the **element**, not index
            }
            if (i < n) {
                stack.push(currIdx); // Push current index
            }
        }

        return pge;
    }
}
