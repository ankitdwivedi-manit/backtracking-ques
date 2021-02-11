
// https://leetcode.com/problems/permutations-ii/
import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums)
            map.put(x, map.getOrDefault(x, 0) + 1);

        solve(map, list, new ArrayList<>(), nums.length);
        return list;
    }

    void solve(HashMap<Integer, Integer> map, List<List<Integer>> sols, List<Integer> sol, int n) {
        if (sol.size() == n) {
            sols.add(new ArrayList<>(sol));
            return;
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 0)
                continue;
            sol.add(key);
            map.put(key, map.get(key) - 1);
            solve(map, sols, sol, n);
            sol.remove(sol.size() - 1);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
    }
}