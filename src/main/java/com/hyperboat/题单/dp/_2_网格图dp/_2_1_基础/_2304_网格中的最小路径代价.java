package com.hyperboat.题单.dp._2_网格图dp._2_1_基础;

public class _2304_网格中的最小路径代价 {

  class Solution {

    public int minPathCost(int[][] grid, int[][] moveCost) {
      int m = grid.length, n = grid[0].length;
      int[] dp = grid[0];
      for (int i = 1; i < m; i++) {
        int[] newDp = new int[n];
        for (int j = 0; j < n; j++) {
          int min = Integer.MAX_VALUE;
          for (int k = 0; k < n; k++) {
            min = Math.min(min, dp[k] + moveCost[grid[i - 1][k]][j]);
          }
          newDp[j] = min + grid[i][j];
        }
        dp = newDp;
      }
      int min = dp[0];
      for (int i : dp) {
        min = Math.min(min, i);
      }
      return min;
    }
  }
}
