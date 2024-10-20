package com.hyperboat.题单.dp._3_背包._3_4_分组背包;

/**
 * 1155. 掷骰子等于目标和的方法数
 * <p>
 * https://leetcode.cn/problems/number-of-dice-rolls-with-target-sum/description/
 */
class LC1155 {

  private static final int MOD = (int) 1e9 + 7;

  public int numRollsToTarget(int n, int k, int target) {
    if (target < n || target > n * k) {
      return 0;
    }
    long[] dp = new long[target - n + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      int max = Math.min(i * (k - 1), target - n);
      for (int j = 1; j <= max; j++) {
        dp[j] += dp[j - 1];
      }
      for (int j = max; j >= k; j--) {
        dp[j] = (dp[j] - dp[j - k]) % MOD;
      }
    }

    return (int) dp[target - n];
  }

}
