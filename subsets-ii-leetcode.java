
// https://leetcode.com/problems/subsets-ii/
import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        solve(list, new ArrayList<>(), 0, nums, true);
        return list;
    }

    void solve(List<List<Integer>> sols, List<Integer> sol, int i, int[] nums, boolean prev) {

        if (i == nums.length) {
            sols.add(new ArrayList<>(sol));
            return;
        }

        if (i > 0 && nums[i] == nums[i - 1]) {
            if (prev) {
                sol.add(nums[i]);
                solve(sols, sol, i + 1, nums, true);
                sol.remove(sol.size() - 1);
                solve(sols, sol, i + 1, nums, false);
            } else {
                solve(sols, sol, i + 1, nums, false);
            }
        } else {
            sol.add(nums[i]);
            solve(sols, sol, i + 1, nums, true);
            sol.remove(sol.size() - 1);
            solve(sols, sol, i + 1, nums, false);
        }
    }
}