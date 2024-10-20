package com.hyperboat.题单.hot100.多维动态规划;

/**
 * 72. 编辑距离
 * <p>
 * https://leetcode.cn/problems/edit-distance/description/
 */
class LC72 {

  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    if (m == 0 || n == 0) {
      return m + n;
    }
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      dp[i][0] = i;
    }
    for (int i = 0; i <= n; i++) {
      dp[0][i] = i;
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        int up = dp[i - 1][j] + 1;
        int left = dp[i][j - 1] + 1;
        int upLeft = word1.charAt(i) == word2.charAt(j) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
        dp[i][j] = Math.min(Math.min(up, left), upLeft);
      }
    }

    return dp[m][n];
  }

}
