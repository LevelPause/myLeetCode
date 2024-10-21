package com.hyperboat.题单.面试经典150题.多维动态规划;

/*
 * https://leetcode.cn/problems/interleaving-string/?envType=study-plan-v2&envId=top-interview-150
 * */
class LC97 {

  public boolean isInterleave(String s1, String s2, String s3) {
    int m = s1.length();
    int n = s2.length();
    int t = s3.length();
    if (m + n != t) {
      return false;
    }
//    dp[i][j]表示s1的前i个元素和s2的前j个元素是否能组成交错
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        int p = i + j - 1;
        if (i > 0) {
          dp[j] &= s1.charAt(i - 1) == s3.charAt(p);
        }
        if (j > 0) {
          dp[j] |= dp[j - 1] && s2.charAt(j - 1) == s3.charAt(p);
        }
      }
    }
    return dp[n];
  }
}
