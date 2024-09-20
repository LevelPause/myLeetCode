package com.hyperboat.题单.dp._2_网格图dp._2_1_基础;

/*
 * https://leetcode.cn/problems/minimum-falling-path-sum/
 * */
public class _931_下降路径最小和 {

  static class Solution {

    public int minFallingPathSum(int[][] matrix) {
      int m = matrix.length;
      int n = matrix[0].length;
      int[] dp = matrix[0];
      for (int i = 1; i < m; i++) {
        int dp_j_1 = 101;
        for (int j = 0; j < n; j++) {
          int min = dp[j];
          if (j > 0) {
            min = Math.min(dp[j], dp_j_1);
          }
          if (j < n - 1) {
            min = Math.min(min, dp[j + 1]);
          }
          dp_j_1 = dp[j];
          dp[j] = min + matrix[i][j];

        }
      }
      int min = dp[0];
      for (int i : dp) {
        min = Math.min(i, min);
      }
      return min;
    }
  }

}
