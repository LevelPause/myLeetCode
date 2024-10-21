package com.hyperboat.题单.面试经典150题.多维动态规划;

class LC64 {

  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
//    dp[k]表示到达(i,j)所用的最短路径
    int[][] dp = new int[m][n];
    dp[0][0] = grid[0][0];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          continue;
        }
        int left = i > 0 ? dp[i - 1][j] : Integer.MAX_VALUE;
        int up = j > 0 ? dp[i][j - 1] : Integer.MAX_VALUE;
        dp[i][j] = Math.min(left, up) + grid[i][j];
      }
    }
    return dp[m - 1][n - 1];
  }
}
