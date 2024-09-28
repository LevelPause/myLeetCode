package com.hyperboat.题单.dp._3_背包._3_3_多重背包;

/*
 * https://leetcode.cn/problems/number-of-ways-to-earn-points/description/
 * */
public class _2585_获得分数的方法数 {

  class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int waysToReachTarget(int target, int[][] types) {
      int n = types.length;
      int[] dp = new int[target + 1];
      dp[0] = 1;
      for (int[] type : types) {
        int count = type[0];
        int mark = type[1];
        for (int j = target; j > 0; j--) {
          for (int k = 1; k <= count && k <= j / mark; k++) {
            dp[j] = (dp[j] + dp[j - k * mark]) % MOD;
          }
        }
      }
      return dp[target];
    }
  }
}
