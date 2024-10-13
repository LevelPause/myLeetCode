package com.hyperboat.竞赛.双周赛141;

/*
 * https://leetcode.cn/contest/biweekly-contest-141/problems/find-maximum-removals-from-source-string/description/
 * */
public class _Q3_从原字符串里进行删除操作的最多次数 {

  class Solution {

    public int maxRemovals(String source, String pattern, int[] targetIndices) {
      int n = source.length(), m = pattern.length();
      boolean[] flag = new boolean[n + 1];
      for (int x : targetIndices) {
        flag[x + 1] = true;
      }

      int[][] f = new int[n + 1][m + 1];
      for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
          f[i][j] = Integer.MIN_VALUE;
        }
      }
      f[0][0] = 0;
      for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
          // 转移 1：跳过 source 的第 i 位
          f[i][j] = f[i - 1][j];
          if (flag[i]) {
            f[i][j]++;
          }
          // 转移 2：用 source 的第 i 位匹配 pattern 的第 j 位
          if (j > 0 && source.charAt(i - 1) == pattern.charAt(j - 1)) {
            f[i][j] = Math.max(f[i][j], f[i - 1][j - 1]);
          }
        }
      }
      return f[n][m];
    }
  }
}
