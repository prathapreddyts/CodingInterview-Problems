package stacks.monotonic;

import java.util.Stack;

public class CelebrityProblem {
    public int celebrity(int[][] M) {
        return celebrity(M,M.length);
    }
    public int celebrity(int[][] M, int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (knows(M, a, b)) {
                // If a knows b, a can't be celebrity
                stack.push(b);
            } else {
                // If a doesn't know b, b can't be celebrity
                stack.push(a);
            }
        }

        // Potential candidate
        int candidate = stack.pop();
        // Verify if candidate is actually a celebrity
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(M, candidate, i) || !knows(M, i, candidate))) {
                return -1; // No celebrity found
            }
        }

        return candidate;
    }

    public boolean knows(int[][] M, int a, int b) {
        return M[a][b] == 1;
    }
}
