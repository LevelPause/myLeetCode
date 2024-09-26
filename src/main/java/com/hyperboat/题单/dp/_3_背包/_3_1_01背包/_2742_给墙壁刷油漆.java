package com.hyperboat.题单.dp._3_背包._3_1_01背包;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/painting-the-walls/description/
 * */
public class _2742_给墙壁刷油漆 {

  class Solution {

    public int paintWalls(int[] cost, int[] time) {
      int n = cost.length;
      int[] dp = new int[n + 1];
      Arrays.fill(dp, Integer.MAX_VALUE / 2);
      dp[0] = 0;
      for (int i = 0; i < cost.length; i++) {
        for (int j = n; j >= 0; j--) {
          dp[j] = Math.min(dp[j], dp[Math.max(j - time[i] - 1, 0)] + cost[i]);
        }
      }
      return dp[n];
    }
  }
}
