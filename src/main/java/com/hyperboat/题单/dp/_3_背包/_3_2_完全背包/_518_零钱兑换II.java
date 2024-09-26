package com.hyperboat.题单.dp._3_背包._3_2_完全背包;

/*
 * https://leetcode.cn/problems/coin-change-ii/description/
 * */
public class _518_零钱兑换II {

  class Solution {

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
}
