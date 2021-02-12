
// https://leetcode.com/problems/combination-sum-iv/submissions/
import java.util.*;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        return combinationSum4Helper(nums, target, new HashMap<Integer, Integer>());
    }

    int combinationSum4Helper(int[] nums, int target, HashMap<Integer, Integer> map) {

        if (map.containsKey(target)) {
            return map.get(target);
        }

        if (target < 0) {
            return 0;
        }

        if (target == 0)
            return 1;

        int ans = 0;
        for (int j = 0; j < nums.length; j++) {
            ans += combinationSum4Helper(nums, target - nums[j], map);
        }

        map.put(target, ans);
        return ans;
    }
}