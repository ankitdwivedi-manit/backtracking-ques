
// https://leetcode.com/problems/combination-sum/
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> sols = new ArrayList<>();
        solve(candidates, target, sols, new ArrayList<>(), 0, 0);
        return sols;
    }

    void solve(int[] candidates, int target, List<List<Integer>> sols, List<Integer> sol, int sum, int i) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            sols.add(new ArrayList<>(sol));
            return;
        }
        if (i >= candidates.length) {
            return;
        }
        // included: i will not increase;
        sol.add(candidates[i]);
        solve(candidates, target, sols, sol, sum + candidates[i], i);
        sol.remove(sol.size() - 1);
        // not included: i will increase;
        solve(candidates, target, sols, sol, sum, i + 1);
    }
}