package com.hyperboat.题单.hot100.动态规划;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * <p>
 * https://leetcode.cn/problems/coin-change/description/
 */
class LC322 {

  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    Arrays.sort(coins);
    for (int i = 1; i < amount + 1; i++) {
      for (int coin : coins) {
        if (coin <= i) {
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }
    }
    return dp[amount] == amount + 1 ? -1 : dp[amount];
  }

}
