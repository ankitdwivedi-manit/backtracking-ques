// https://leetcode.com/problems/combinations/submissions/

import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> sols = new ArrayList<>();
        solve(1, n, sols, new ArrayList<>(), k);
        return sols;
    }

    void solve(int i, int n, List<List<Integer>> sols, List<Integer> sol, int k) {

        if (sol.size() > k)
            return;

        if (sol.size() == k) {
            sols.add(new ArrayList<>(sol));
            return;
        }
        for (int j = i; j <= n; j++) {
            if (sol.size() == n)
                return;
            sol.add(j);
            solve(j + 1, n, sols, sol, k);
            sol.remove(sol.size() - 1);
        }
    }

    void solveOptimised(int i, int n, List<List<Integer>> sols, List<Integer> sol, int k) {
        if (sol.size() == k) {
            sols.add(new ArrayList<>(sol));
            return;
        }

        for (int j = i; j <= n; j++) {

            if ((n - j + 1) + sol.size() < k) {
                return;
            }

            sol.add(j);
            solve(j + 1, n, sols, sol, k);
            sol.remove(sol.size() - 1);
        }
    }
}