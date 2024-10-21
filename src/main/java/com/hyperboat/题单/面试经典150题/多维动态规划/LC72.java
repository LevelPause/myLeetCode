package com.hyperboat.题单.面试经典150题.多维动态规划;

/*
 * https://leetcode.cn/problems/edit-distance/description/?envType=study-plan-v2&envId=top-interview-150
 * */
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
    for (int j = 0; j <= n; j++) {
      dp[0][j] = j;
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        int left = dp[i][j - 1] + 1;
        int up = dp[i - 1][j] + 1;
        int upLeft =
            word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
        dp[i][j] = Math.min(left, Math.min(upLeft, up));
      }
    }
    return dp[m][n];
  }
}
