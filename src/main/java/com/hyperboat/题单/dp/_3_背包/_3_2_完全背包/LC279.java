package com.hyperboat.题单.dp._3_背包._3_2_完全背包;

import java.util.Arrays;

/**
 * 279. 完全平方数
 * <p>
 * https://leetcode.cn/problems/perfect-squares/description/
 */
class LC279 {

  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE / 2);
    dp[0] = 0;
    for (int i = 1; i * i <= n; i++) {
      int x = i * i;
      for (int j = x; j <= n; j++) {
        dp[j] = Math.min(dp[j], dp[j - x] + 1);
      }
    }
    return dp[n];
  }

}
