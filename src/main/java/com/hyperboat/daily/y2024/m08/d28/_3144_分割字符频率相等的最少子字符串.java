package com.hyperboat.daily.y2024.m08.d28;

import java.util.Arrays;

public class _3144_分割字符频率相等的最少子字符串 {

  class Solution {

    public int minimumSubstringsInPartition(String s) {
      int n = s.length();
      int[] dp = new int[n + 1];
      Arrays.fill(dp, Integer.MAX_VALUE);
      dp[0] = 0;
      int[] cnt = new int[26];
      for (int i = 0; i < n; i++) {
        Arrays.fill(cnt, 0);
        int maxCnt = 0;
        int k = 0;
        for (int j = i; j >= 0; j--) {
          int index = s.charAt(j) - 'a';
          k += cnt[index]++ == 0 ? 1 : 0;
          maxCnt = Math.max(maxCnt, cnt[index]);
          if (i - j + 1 == k * maxCnt) {
            dp[i + 1] = Math.min(dp[i + 1], dp[j] + 1);
          }
        }
      }
      return dp[n];
    }

  }
}
