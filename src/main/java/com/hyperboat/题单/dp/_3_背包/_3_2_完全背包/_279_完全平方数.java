package com.hyperboat.题单.dp._3_背包._3_2_完全背包;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/perfect-squares/description/
 * */
public class _279_完全平方数 {

  class Solution {

    public int numSquares(int n) {
      int[] dp = new int[n + 1];
      Arrays.fill(dp, Integer.MAX_VALUE / 2);
      dp[0] = 0;
      for (int i = 1; i * i <= n; i++) {
        int x = i * i;
        for (int j = x; j <= n; j++) {
          dp[j] = Math.min(dp[j], dp[j - x] + 1);
        }
      }
      return dp[n];
    }
  }
}
