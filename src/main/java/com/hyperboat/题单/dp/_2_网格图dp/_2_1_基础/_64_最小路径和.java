package com.hyperboat.题单.dp._2_网格图dp._2_1_基础;

/*
 * https://leetcode.cn/problems/minimum-path-sum/
 * */
public class _64_最小路径和 {

  class Solution {

    public int minPathSum(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int[] dp = grid[0];
      for (int i = 1; i < n; i++) {
        dp[i] += dp[i - 1];
      }
      for (int i = 1; i < m; i++) {
        dp[0] += grid[i][0];
        for (int j = 1; j < n; j++) {
          dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
        }
      }
      return dp[n - 1];
    }
  }
}
