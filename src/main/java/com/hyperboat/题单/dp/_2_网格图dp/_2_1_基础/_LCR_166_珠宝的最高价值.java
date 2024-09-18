package com.hyperboat.题单.dp._2_网格图dp._2_1_基础;

public class _LCR_166_珠宝的最高价值 {

  class Solution {

    public int jewelleryValue(int[][] frame) {
      return O1(frame);
    }

    // 空间复杂度O(mn)
    private int Omn(int[][] frame) {
      int m = frame.length;
      int n = frame[0].length;
      int[][] dp = new int[m][n];
      dp[0][0] = frame[0][0];
      for (int i = 1; i < m; i++) {
        dp[i][0] = frame[i][0] + dp[i - 1][0];
      }
      for (int i = 1; i < n; i++) {
        dp[0][i] = frame[0][i] + dp[0][i - 1];
      }
      for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + frame[i][j];
        }
      }
      return dp[m - 1][n - 1];
    }

    // 空间复杂度O(n)
    private int On(int[][] frame) {
      int m = frame.length;
      int n = frame[0].length;
      int[] dp = new int[n];
      for (int i = 0; i < m; i++) {
        dp[0] += frame[i][0];
        for (int j = 1; j < n; j++) {
          dp[j] = Math.max(dp[j], dp[j - 1]) + frame[i][j];
        }
      }
      return dp[n - 1];
    }

    //  空间复杂度O(1), 仍然使用一维数组, 只不过此一维数组占用的是源数组的第一行, 也就是原地修改的思想
    private int O1(int[][] frame) {
      int m = frame.length;
      int n = frame[0].length;
      int[] dp = frame[0];
      for (int i = 1; i < n; i++) {
        dp[i] += dp[i - 1];
      }
      for (int i = 1; i < m; i++) {
        dp[0] += frame[i][0];
        for (int j = 1; j < n; j++) {
          dp[j] = Math.max(dp[j], dp[j - 1]) + frame[i][j];
        }
      }
      return dp[n - 1];
    }
  }
}
