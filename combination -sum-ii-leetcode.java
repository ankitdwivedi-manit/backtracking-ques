
// https://leetcode.com/problems/combination-sum-ii/submissions/
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> sols = new ArrayList<>();
        solve(candidates, 0, target, sols, new ArrayList<Integer>());
        return sols;
    }

    void solve(int[] arr, int i, int target, List<List<Integer>> sols, List<Integer> sol) {
        if (target == 0) {
            sols.add(new ArrayList(sol));
            return;
        }
        if (i == arr.length) {
            return;
        }
        for (int j = i; j < arr.length; j++) {
            if (arr[j] > target) {
                return;
            }
            if (j > i && arr[j] == arr[j - 1]) {
                continue;
            }
            sol.add(arr[j]);
            solve(arr, j + 1, target - arr[j], sols, sol);
            sol.remove(sol.size() - 1);
        }
    }
}