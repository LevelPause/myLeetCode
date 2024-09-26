package com.hyperboat.题单.dp._3_背包._3_1_01背包;

/*
 * https://leetcode.cn/problems/oPs9Bm/description/
 * */
public class _LCP47_入场安检 {

  class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int securityCheck(int[] capacities, int k) {
      int[] dp = new int[k + 1];
      dp[0] = 1;
      for (int i : capacities) {
        i--;
        for (int j = k; j >= i; j--) {
          dp[j] = (dp[j] + dp[j - i]) % MOD;
        }
      }
      return dp[k];
    }
  }
}
