package com.hyperboat.hot100.多维动态规划;

/*
 * https://leetcode.cn/problems/minimum-path-sum/description/?envType=study-plan-v2&envId=top-100-liked
 * */
public class _64_最小路径和 {

  class Solution {

    public int minPathSum(int[][] grid) {
      return On(grid);
    }

    public int On(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int[] dp = new int[n];
      dp[0] = grid[0][0];
      for (int i = 1; i < n; i++) {
        dp[i] = dp[i - 1] + grid[0][i];
      }
      for (int i = 1; i < m; i++) {
        dp[0] += grid[i][0];
        for (int j = 1; j < n; j++) {
          dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
        }
      }
      return dp[n - 1];
    }

    public int Omn(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int[][] dp = new int[m][n];
      dp[0][0] = grid[0][0];
      for (int i = 1; i < m; i++) {
        dp[i][0] = dp[i - 1][0] + grid[i][0];
      }
      for (int i = 1; i < n; i++) {
        dp[0][i] = dp[0][i - 1] + grid[0][i];
      }
      for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
          dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
        }
      }
      return dp[m - 1][n - 1];
    }
  }
}
