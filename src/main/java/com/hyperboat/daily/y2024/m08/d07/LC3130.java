package com.hyperboat.daily.y2024.m08.d07;

/*
 * https://leetcode.cn/problems/find-all-possible-stable-binary-arrays-ii/
 * */
public class LC3130 {

  public int numberOfStableArrays(int zero, int one, int limit) {
    int MOD = 1_000_000_007;
    int[][][] dp = new int[zero + 1][one + 1][2];
    for (int i = 1; i <= Math.min(zero, limit); i++) {
      dp[i][0][0] = 1;
    }
    for (int i = 1; i <= Math.min(one, limit); i++) {
      dp[0][i][1] = 1;
    }
    for (int i = 1; i <= zero; i++) {
      for (int j = 1; j <= one; j++) {
        dp[i][j][0] =
            (int) (((long) dp[i - 1][j][0] + dp[i - 1][j][1]
                + (i > limit ? MOD - dp[i - limit - 1][j][1] : 0)) % MOD);
        dp[i][j][1] =
            (int) (((long) dp[i][j - 1][0] + dp[i][j - 1][1]
                + (j > limit ? MOD - dp[i][j - limit - 1][0] : 0)) % MOD);
      }
    }
    return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
  }
}
