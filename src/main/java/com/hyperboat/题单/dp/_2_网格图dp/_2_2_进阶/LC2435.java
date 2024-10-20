package com.hyperboat.题单.dp._2_网格图dp._2_2_进阶;

/**
 * 2435. 矩阵中和能被K整除的路径
 * <p>
 * https://leetcode.cn/problems/paths-in-matrix-whose-sum-is-divisible-by-k/description/
 */
class LC2435 {

  public int numberOfPaths(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;
    int[][][] dp = new int[m + 1][n + 1][k];
    int mod = (int) 1e9 + 7;
    dp[0][1][0] = 1;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int x = grid[i][j];
        for (int v = 0; v < k; v++) {
          dp[i + 1][j + 1][(v + x) % k] = (dp[i][j + 1][v] + dp[i + 1][j][v]) % mod;
        }
      }
    }
    return dp[m][n][0];
  }

}
