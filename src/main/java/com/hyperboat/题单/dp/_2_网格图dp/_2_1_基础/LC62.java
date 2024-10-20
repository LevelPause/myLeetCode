package com.hyperboat.题单.dp._2_网格图dp._2_1_基础;

/**
 * 62. 不同路径
 * <p>
 * https://leetcode.cn/problems/unique-paths/description/
 */
class LC62 {

  public int uniquePaths(int m, int n) {
    return On(m, n);
  }

  //    空间复杂度O(mn)
  public int Omn(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }
    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }

  //    空间复杂度O(n)
  public int On(int m, int n) {
    int[] dp = new int[n];
    for (int i = 0; i < m; i++) {
      dp[0] = 1;
      for (int j = 1; j < n; j++) {
        dp[j] = dp[j] + dp[j - 1];
      }
    }
    return dp[n - 1];
  }

}
