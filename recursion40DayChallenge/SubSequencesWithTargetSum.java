package recursion40DayChallenge;

import java.util.ArrayList;
import java.util.List;

public class SubSequencesWithTargetSum {

    public int countSubsequenceWithTargetSum(int[] nums, int target) {
        // Use an array to hold count, as Java passes arrays by reference
        int[] count = new int[1];
        countSubsequenceWithTargetSum(0, nums.length, 0, count, nums, target);
        return count[0];
    }

    private void countSubsequenceWithTargetSum(int i, int len, int sum, int[] count, int[] nums, int target) {
        // Base case: if we've processed all elements
        if (i == len) {
            if (sum == target) {
                count[0]++;
            }
            return;
        }

        // Include the current element
        countSubsequenceWithTargetSum(i + 1, len, sum + nums[i], count, nums, target);

        // Exclude the current element
        countSubsequenceWithTargetSum(i + 1, len, sum, count, nums, target);
    }
}

