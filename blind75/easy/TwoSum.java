package blind75.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSumPointers(int[] nums, int target) {
        int[] result = new int[2];
        int[] tempArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tempArray[i] = nums[i];
        }
        Arrays.sort(tempArray);
        int start = 0;
        int end = tempArray.length - 1;
        while (start < end) {
            if (tempArray[start] + tempArray[end] == target) {
                break;
            } else if (tempArray[start] + tempArray[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        boolean isFirstIndexFilled = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == tempArray[start] && !isFirstIndexFilled) {
                result[0] = i;
                isFirstIndexFilled = true;
            } else if (tempArray[end] == nums[i]) {
                result[1] = i;
            }
        }
        return result;
    }

    public int[] twoSumHashing(int[] nums, int target) {
        int result[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
            } else {
                map.put(nums[i], i);
            }
        }
        return result;

    }
}
