package com.hyperboat.题单.dp._2_网格图dp._2_2_进阶;

/**
 * 1937. 扣分后的最大得分
 * <p>
 * <p>
 * https://leetcode.cn/problems/maximum-number-of-points-with-cost/description/
 */
class LC1937 {

  public long maxPoints(int[][] points) {
    int m = points.length;
    int n = points[0].length;
    long[][] dp = new long[m][n];
    for (int i = 0; i < n; i++) {
      dp[0][i] = points[0][i];
    }
    for (int i = 1; i < m; i++) {
      long max = Integer.MIN_VALUE;
      for (int j = 0; j < n; j++) {
        max = Math.max(max, dp[i - 1][j] + j);
        dp[i][j] = Math.max(dp[i][j], max + points[i][j] - j);
      }
      max = Integer.MIN_VALUE;
      for (int j = n - 1; j >= 0; j--) {
        max = Math.max(max, dp[i - 1][j] - j);
        dp[i][j] = Math.max(dp[i][j], max + points[i][j] + j);
      }
    }
    long ans = Long.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      ans = Math.max(ans, dp[m - 1][i]);
    }
    return ans;
  }

}
