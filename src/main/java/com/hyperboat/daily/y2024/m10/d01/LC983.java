package com.hyperboat.daily.y2024.m10.d01;

/**
 * https://leetcode.cn/problems/minimum-cost-for-tickets/description/
 */
public class LC983 {

  class Solution {

    public int mincostTickets(int[] days, int[] costs) {
      int n = days.length;
      int max = days[n - 1];
      int[] dp = new int[max + 1];
      for (int i = 1, j = 0; j < n && i <= max; i++) {
        dp[i] = dp[i - 1];
        if (i == days[j]) {
          dp[i] = dp[Math.max(0, i - 1)] + costs[0];
          dp[i] = Math.min(dp[i], dp[Math.max(0, i - 7)] + costs[1]);
          dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]);
          j++;
        }
      }
      return dp[max];
    }
  }
}
