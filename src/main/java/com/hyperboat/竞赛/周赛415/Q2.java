package com.hyperboat.竞赛.周赛415;

/*
 * https://leetcode.cn/contest/weekly-contest-415/problems/maximum-multiplication-score/
 * */
public class Q2 {

  class Solution {

    public long maxScore(int[] a, int[] b) {
      long[][] dp = new long[a.length][b.length];
      for (int i = 0; i < a.length; i++) {
        dp[i][i] = (i > 0 ? dp[i - 1][i - 1] : 0) + (long) a[i] * b[i];
        for (int j = i + 1; j < b.length; j++) {
          dp[i][j] = Math.max(dp[i][j - 1], (i > 0 ? dp[i - 1][j - 1] : 0) + (long) a[i] * b[j]);
        }
      }
      return dp[a.length - 1][b.length - 1];
    }
  }
}
