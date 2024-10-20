package com.hyperboat.daily.y2024.m08.d11;

class LC1035 {

  public int maxUncrossedLines(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
//    dp[i][j]表示nums1的前i个元素和nums2的前j个元素所能组成的最多的不相交的线的数量
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
        if (nums1[i] == nums1[j]) {
          dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + 1);
        }
      }
    }
    return dp[m][n];
  }
}
