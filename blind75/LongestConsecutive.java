package blind75;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int max = 1;

        for (int num : nums) {
            if (set.remove(num)) { // only process if num hasn't been visited
                int currentLength = 1;

                // Expand to left
                int left = num - 1;
                while (set.remove(left)) {
                    currentLength++;
                    left--;
                }

                // Expand to right
                int right = num + 1;
                while (set.remove(right)) {
                    currentLength++;
                    right++;
                }

                max = Math.max(max, currentLength);
            }
        }

        return max;
    }
}

