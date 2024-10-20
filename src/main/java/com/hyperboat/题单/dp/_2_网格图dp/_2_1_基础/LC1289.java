package com.hyperboat.题单.dp._2_网格图dp._2_1_基础;

/**
 * 1289. 下降路径最小和 II
 * <p>
 * https://leetcode.cn/problems/minimum-falling-path-sum-ii/description/
 */
class LC1289 {

  class Solution {

    public int minFallingPathSum(int[][] grid) {
      int n = grid.length;
      int[][] dp = new int[2][n];
      dp[0] = grid[0];
      int index = 1;
      for (int i = 1; i < n; i++) {
        for (int j = 0; j < n; j++) {
          dp[index][j] = Integer.MAX_VALUE;
          for (int k = 0; k < n; k++) {
            if (k != j) {
              dp[index][j] = Math.min(dp[index][j], dp[1 - index][k] + grid[i][j]);
            }
          }
        }
        index = 1 - index;
      }
      int min = dp[1 - index][0];
      for (int i : dp[1 - index]) {
        min = Math.min(i, min);
      }
      return min;
    }
  }

}
