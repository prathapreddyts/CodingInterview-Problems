package recursion40DayChallenge;

import java.util.List;

public class IsSubSequencesWithTargetSum {
    public boolean checkSubsequenceSum(int[] nums, int target) {
        int n = nums.length;
        return solve(0, n, nums, target, 0);
    }

    private boolean solve(int i, int n, int[] arr, int k, int elementsTaken) {
        if (i == n) {
            return k == 0 && elementsTaken > 0;
        }
        if (k < 0) {
            return false;
        }
        if (solve(i + 1, n, arr, k - arr[i], elementsTaken + 1)) {
            return true;
        }
        if (solve(i + 1, n, arr, k, elementsTaken)) {
            return true;
        }

        return false;
    }

}
