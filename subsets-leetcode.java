
// https://leetcode.com/problems/subsets/
import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> sols = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        solve(nums, 0, n, sols, sol);
        return sols;
    }

    void solve(int[] nums, int i, int n, List<List<Integer>> sols, List<Integer> sol) {
        if (i == n) {
            sols.add(new ArrayList<>(sol));
            return;
        }
        sol.add(nums[i]);
        solve(nums, i + 1, n, sols, sol);
        sol.remove(sol.size() - 1);
        solve(nums, i + 1, n, sols, sol);
    }
}