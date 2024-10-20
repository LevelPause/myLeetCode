package com.hyperboat.题单.dp._3_背包._3_2_完全背包;

/**
 * 518. 零钱兑换II
 * <p>
 * https://leetcode.cn/problems/coin-change-ii/description/
 */
class LC518 {

  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int i = coin; i < amount + 1; i++) {
        dp[i] = dp[i] + dp[i - coin];
      }
    }
    return dp[amount];
  }

}
