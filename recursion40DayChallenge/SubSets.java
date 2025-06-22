package recursion40DayChallenge;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        subSetsHelper(nums, 0, nums.length, current, ans);
        return ans;
    }


    public void subSetsHelper(int[] nums, int index, int size, List<Integer> current,
                              List<List<Integer>> resultList) {
        if (index == size) {
            resultList.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        subSetsHelper(nums, index + 1, size, current, resultList);
        current.remove(current.size() - 1);
        subSetsHelper(nums, index + 1, size, current, resultList);
    }

}
