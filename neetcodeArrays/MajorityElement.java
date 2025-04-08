package neetcodeArrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int temp = nums[0];
        for (int val : nums) {
            if (count == 0) {
                temp = val;
            }
            if (temp == val) {
                count++;
            } else {
                count--;
            }
        }
        return temp; 
    }

}

