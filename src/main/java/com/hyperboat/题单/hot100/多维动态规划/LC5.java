package com.hyperboat.题单.hot100.多维动态规划;

/**
 * 5. 最长回文子串
 * <p>
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 */
class LC5 {

  private int maxL;
  private int maxR;

  public String longestPalindrome(String s) {
    return extend(s);
  }

  private String dp(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      dp[i][i] = true;
    }

    String ans = "";
    int maxI = 0;
    int maxJ = 0;
    for (int l = 1; l < n; l++) {
      for (int i = 0; i < n - l; i++) {
        int j = i + l;
        if (j > n - 1) {
          break;
        }
        dp[i][j] = (j <= i + 1 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j);
        if (dp[i][j] && j - i > maxJ - maxI) {
          maxI = i;
          maxJ = j;
        }
      }
    }

    return s.substring(maxI, maxJ + 1);
  }

  private String extend(String s) {
    int n = s.length();
    maxL = 0;
    maxR = 0;
    for (int i = 0; i < n; i++) {
      extend(s, i, i);
      if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
        extend(s, i, i + 1);
      }
    }
    return s.substring(maxL, maxR + 1);
  }

  private void extend(String s, int l, int r) {
    while (l > 0 && r < s.length() - 1 && s.charAt(l - 1) == s.charAt(r + 1)) {
      l--;
      r++;
    }
    if (r - l > maxR - maxL) {
      maxL = l;
      maxR = r;
    }
  }

}
