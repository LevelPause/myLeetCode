package com.hyperboat.题单.面试经典150题.多维动态规划;

/*
 * https://leetcode.cn/problems/maximal-square/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _221最大正方形 {

  public int maximalSquare(char[][] matrix) {
    return dp2(matrix);
  }

  public int dp1(char[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean[][] dp = new boolean[m][n];
    int ans = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') {
          dp[i][j] = true;
          ans = 1;
        }
      }
    }
    int l = Math.min(m, n);
    for (int k = 1; k < l; k++) {
      for (int i = m - 1; i >= k; i--) {
        for (int j = n - 1; j >= k; j--) {
          dp[i][j] = dp[i - 1][j]
              && dp[i][j - 1]
              && matrix[i][j] == '1'
              && matrix[i - k][j - k] == '1';
          if (dp[i][j]) {
            ans = (k + 1) * (k + 1);
          }
        }
      }
    }
    return ans;

  }

  public int dp2(char[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];
    int ans = 0;
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == '1') {
        dp[i][0] = 1;
        ans = 1;
      }
    }
    for (int j = 0; j < n; j++) {
      if (matrix[0][j] == '1') {
        dp[0][j] = 1;
        ans = 1;
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == '1') {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
          ans = Math.max(ans,dp[i][j]*dp[i][j]);
        }
      }
    }
    return ans;
  }
}
