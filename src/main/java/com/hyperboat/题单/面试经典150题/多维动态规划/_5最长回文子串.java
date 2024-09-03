package com.hyperboat.题单.面试经典150题.多维动态规划;

/*
 * https://leetcode.cn/problems/longest-palindromic-substring/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _5最长回文子串 {

  public String longestPalindrome(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      dp[i][i] = true;
      if (i + 1 < n) {
        dp[i + 1][i] = true;
      }
    }
    int start = 0;
    int end = 0;
    for (int l = 2; l < n; l++) {
      for (int i = 0; i < n; i++) {
        int j = i + l - 1;
        if (j >= n) {
          break;
        }
        dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
        if (dp[i][j]) {
          start = i;
          end = j;
        }
      }
    }
    return s.substring(start, end + 1);
  }
}
