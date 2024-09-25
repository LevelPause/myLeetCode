package com.hyperboat.题单.dp._3_背包._3_1_01背包;

/*
 * https://leetcode.cn/problems/ones-and-zeroes/
 * */
public class _474_一和零 {

  class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
      int[][] dp = new int[m + 1][n + 1];
      for (String str : strs) {
        int cnt0 = 0;
        int cnt1 = 0;

        for (char c : str.toCharArray()) {
          if (c == '0') {
            cnt0++;
          } else {
            cnt1++;
          }
        }

        for (int i = m; i >= cnt0; i--) {
          for (int j = n; j >= cnt1; j--) {
            dp[i][j] = Math.max(dp[i][j], dp[i - cnt0][j - cnt1] + 1);
          }
        }

      }

      return dp[m][n];
    }
  }
}
