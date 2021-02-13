
// https://leetcode.com/problems/n-queens/
import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[][] arr = new int[n][n];
        List<List<String>> sols = new ArrayList<>();
        solve(arr, n, sols, 0);
        return sols;
    }

    void solve(int[][] arr, int n, List<List<String>> sols, int i) {
        if (i == n) {
            List<String> sol = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                String str = "";
                for (int c = 0; c < n; c++) {
                    if (arr[r][c] == 1)
                        str += 'Q';
                    else
                        str += '.';
                }
                sol.add(str);
            }
            sols.add(new ArrayList(sol));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (check(arr, i, j)) {
                arr[i][j] = 1;
                solve(arr, n, sols, i + 1);
                arr[i][j] = 0;
            }
        }
    }

    boolean check(int[][] arr, int r, int c) {
        int n = arr.length;
        for (int i = r - 1; i >= 0; i--) {
            if (arr[i][c] == 1) {
                return false;
            }
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 1) {
                return false;
            }
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
            if (arr[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}