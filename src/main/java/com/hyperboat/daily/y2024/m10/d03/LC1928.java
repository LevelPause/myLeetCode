package com.hyperboat.daily.y2024.m10.d03;

import java.util.Arrays;

/*
 *
 * https://leetcode.cn/problems/minimum-cost-to-reach-destination-in-time/description/
 * */
class LC1928 {

  class Solution {

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
      int n = passingFees.length;
      int[][] dp = new int[maxTime + 1][n];
      for (int i = 0; i <= maxTime; i++) {
        Arrays.fill(dp[i], Integer.MAX_VALUE);
      }
      dp[0][0] = passingFees[0];
      for (int t = 1; t <= maxTime; t++) {
        for (int[] edge : edges) {
          int i = edge[0], j = edge[1], cost = edge[2];
          if (cost <= t) {
            if (dp[t - cost][i] != Integer.MAX_VALUE) {
              dp[t][j] = Math.min(dp[t][j], dp[t - cost][i] + passingFees[j]);
            }
            if (dp[t - cost][j] != Integer.MAX_VALUE) {
              dp[t][i] = Math.min(dp[t][i], dp[t - cost][j] + passingFees[i]);
            }
          }
        }
      }
      int ans = Integer.MAX_VALUE;
      for (int i = 0; i <= maxTime; i++) {
        ans = Math.min(dp[i][n - 1], ans);
      }
      return ans == Integer.MAX_VALUE ? -1 : ans;
    }
  }
}
