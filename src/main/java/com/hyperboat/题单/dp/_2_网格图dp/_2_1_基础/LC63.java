package com.hyperboat.题单.dp._2_网格图dp._2_1_基础;

import java.util.Arrays;

/**
 * 63. 不同路径II https://leetcode.cn/problems/unique-paths-ii/
 */
class LC63 {

  //  dp 空间复杂度: O1
  public int uniquePathsWithObstacles(int[][] o) {
    int m = o.length;
    int n = o[0].length;
    int[] dp = o[0];

    for (int i = 0; i < n; i++) {
      if (o[0][i] == 1) {
        Arrays.fill(dp, i, n, 0);
        break;
      }
      dp[i] = 1;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (o[i][j] == 1) {
          dp[j] = 0;
          continue;
        }
        if (j > 0) {
          dp[j] += dp[j - 1];
        }
      }
    }

    return dp[n - 1];
  }

}
