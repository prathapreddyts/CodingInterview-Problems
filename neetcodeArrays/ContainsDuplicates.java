package neetcodeArrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++) {
            if (set.contains(nums[i])) {
                return true;
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }
}
