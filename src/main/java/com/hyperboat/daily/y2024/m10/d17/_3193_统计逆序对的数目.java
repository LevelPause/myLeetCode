package com.hyperboat.daily.y2024.m10.d17;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/count-the-number-of-inversions/description/
 * */
public class _3193_统计逆序对的数目 {

  class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int numberOfPermutations(int n, int[][] requirements) {
      var req = new int[n];
      Arrays.fill(req, -1);
      req[0] = 0;
      var max = 0;
      for (int[] row : requirements) {
        req[row[0]] = row[1];
        max = Math.max(row[1], max);
      }
      if (req[0] > 0) {
        return 0;
      }
      var dp = new int[n][max + 1];
      dp[0][0] = 1;
      for (int i = 1; i < n; i++) {
        var t = req[i];
        if (t >= 0) {
          for (int k = 0; k <= i; k++) {
            if (t >= k) {
              dp[i][t] = (dp[i][t] + dp[i - 1][t - k]) % MOD;
            } else {
              break;
            }
          }
        } else {
          var total = 0;
          for (int j = 0; j <= max; j++) {
            total = (total + dp[i - 1][j]) % MOD;
            if (j - (i + 1) >= 0) {
              total = (total - dp[i - 1][j - (i + 1)] + MOD) % MOD;
            }
            dp[i][j] = total;
          }
        }
      }
      return dp[n - 1][max];
    }
  }
}
