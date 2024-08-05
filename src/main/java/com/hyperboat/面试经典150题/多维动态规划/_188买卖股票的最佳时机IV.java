package com.hyperboat.面试经典150题.多维动态规划;

/*
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _188买卖股票的最佳时机IV {

  public int maxProfit(int k, int[] prices) {
    int[] dp = new int[k * 2];
    for (int i = 0; i < k * 2; i++) {
      if ((i & 1) == 0) {
        dp[i] = -prices[0];
      }
    }
    for (int i = 1; i < prices.length; i++) {
      int p = prices[i];
      int flag = 1;
      for (int j = 0; j < k * 2; j++) {
        flag = -flag;
        dp[j] = Math.max(dp[j], j > 0 ? dp[j - 1] + p * flag : p * flag);
      }
    }
    return dp[k * 2 - 1];
  }
}
