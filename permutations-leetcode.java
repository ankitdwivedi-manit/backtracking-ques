
// https://leetcode.com/problems/permutations/
import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, 0, ans);
        return ans;
    }

    void solve(int[] nums, int i, List<List<Integer>> sols) {
        if (i == nums.length) {
            ArrayList<Integer> sol = new ArrayList<>();
            for (int x : nums)
                sol.add(x);
            sols.add(sol);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            solve(nums, i + 1, sols);
            swap(nums, i, j);
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}