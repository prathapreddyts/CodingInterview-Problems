package recursion40DayChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets11 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        Arrays.sort(nums);
        subSetsHelper(0, arr, nums, ans);
        return ans;
    }

    private void subSetsHelper(int ind, List<Integer> arr, int[] nums, List<List<Integer>> ans) {
        if (ind == nums.length) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[ind]);

        subSetsHelper(ind + 1, arr, nums, ans);
        arr.remove(arr.size() - 1);
        for (int j = ind + 1; j < nums.length; j++) {
            if (nums[j] != nums[ind]) {
                subSetsHelper(j, arr, nums, ans);
                return;
            }
        }
        subSetsHelper(nums.length, arr, nums, ans);
    }


}
