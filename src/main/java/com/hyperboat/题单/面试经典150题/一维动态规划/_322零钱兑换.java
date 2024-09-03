package com.hyperboat.题单.面试经典150题.一维动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.cn/problems/coin-change/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _322零钱兑换 {

  public int coinChange(int[] coins, int amount) {
    return dp(coins, amount);
  }

  /*经典完全背包问题，枚举值域，找到所需最小枚举背包次数*/
  public int dp(int[] coins, int amount) {
    //    dp[i] 表示以num[i]结尾的子序列的最大长度(包含num[i])
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
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
