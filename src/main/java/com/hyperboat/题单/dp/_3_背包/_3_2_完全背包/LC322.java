package com.hyperboat.题单.dp._3_背包._3_2_完全背包;

import java.util.Arrays;

/**
 * 322. 零钱兑换 https://leetcode.cn/problems/coin-change/description/
 */
class LC322 {

  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int coin : coins) {
      for (int i = coin; i < amount + 1; i++) {
        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
      }
    }
    return dp[amount] == amount + 1 ? -1 : dp[amount];
  }

}
