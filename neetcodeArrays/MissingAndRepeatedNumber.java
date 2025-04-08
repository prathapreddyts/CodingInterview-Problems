package neetcodeArrays;

public class MissingAndRepeatedNumber {
    public int[] findMissingRepeatingNumbersUsingHash(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n + 1];
        for (int i = 0; i < n; i++) {
            hash[nums[i]]++;
        }
        int missing = -1;
        int repeating = -1;
        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 2) {
                repeating = i;
            }
            if (hash[i] == 0) {
                missing = i;
            }
            if (repeating != -1 && missing != -1) {
                break;
            }
        }

        return new int[]{repeating, missing};
    }

    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;
        int sumOfN = n * (n + 1) / 2;
        int sumSqOfN = n * (n + 1) * (2 * n + 1) / 6;
        int actSumOfN = 0;
        int actSumSqOfN = 0;
        for (int num : nums) {
            actSumOfN += num;
            actSumSqOfN += num * num;
        }
        int val1 = actSumOfN - sumOfN; // x - y
        int val2 = actSumSqOfN - sumSqOfN; // x^2 - y^2
        int val3 = val2 / val1; // x + y
        int x = (val1 + val3) / 2; // Repeating number
        int y = x - val1;          // Missing number

        return new int[]{x, y}; // [repeating, missing]
    }


}
