package com.hyperboat.竞赛.双周赛141;

/*
 * https://leetcode.cn/problems/find-the-number-of-possible-ways-for-an-event/description/
 * */
public class _Q4_安排活动的方案数 {

  class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int numberOfWays(int n, int x, int y) {
      long[][] f = new long[n + 1][x + 1];
      f[0][0] = 1;
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= x; j++) {
          f[i][j] = (f[i - 1][j] * j + f[i - 1][j - 1] * (x - j + 1)) % MOD;
        }
      }
      long ans = 0, p = 1;
      for (int j = 1; j <= x; j++) {
        p = p * y % MOD;
        ans = (ans + f[n][j] * p) % MOD;
      }
      return (int) ans;
    }
  }
}
