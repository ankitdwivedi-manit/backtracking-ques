
// https://leetcode.com/problems/combination-sum-iii/
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> sols = new ArrayList<>();
        solve(k, n, 1, sols, new ArrayList<>());
        return sols;
    }

    void solve(int k, int n, int i, List<List<Integer>> sols, List<Integer> sol) {
        if (n == 0 && sol.size() == k) {
            sols.add(new ArrayList<>(sol));
            return;
        }

        for (int j = i; j <= 9; j++) {

            if (j > n) {
                return;
            }
            if (sol.size() == k) {
                return;
            }

            sol.add(j);
            solve(k, n - j, j + 1, sols, sol);
            sol.remove(sol.size() - 1);
        }
    }
}