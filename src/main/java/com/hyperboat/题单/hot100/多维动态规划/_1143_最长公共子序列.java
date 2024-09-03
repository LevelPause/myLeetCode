package com.hyperboat.题单.hot100.多维动态规划;

public class _1143_最长公共子序列 {

  class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
      int m = text1.length();
      int n = text2.length();
      if (m > n) {
        return longestCommonSubsequence(text2, text1);
      }
      int[] dp = new int[m + 1];
      for (int i = 0; i < n; i++) {
        int pre = 0;
        for (int j = 0; j < m; j++) {
          int t = dp[j + 1];
          dp[j + 1] = text1.charAt(j) == text2.charAt(i) ? pre + 1 : Math.max(dp[j + 1], dp[j]);
          pre = t;
        }
      }
      return dp[m];
    }
  }
}
