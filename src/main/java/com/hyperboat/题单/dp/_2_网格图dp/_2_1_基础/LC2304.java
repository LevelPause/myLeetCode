package com.hyperboat.题单.dp._2_网格图dp._2_1_基础;

/**
 * 2304. 网格中的最小路径代价
 * <p>
 * https://leetcode.cn/problems/minimum-path-cost-in-a-grid/description/
 */
class LC2304 {

  public int minPathCost(int[][] grid, int[][] moveCost) {
    int m = grid.length, n = grid[0].length;
    int[] dp = grid[0];
    for (int i = 1; i < m; i++) {
      int[] newDp = new int[n];
      for (int j = 0; j < n; j++) {
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
          min = Math.min(min, dp[k] + moveCost[grid[i - 1][k]][j]);
        }
        newDp[j] = min + grid[i][j];
      }
      dp = newDp;
    }
    int min = dp[0];
    for (int i : dp) {
      min = Math.min(min, i);
    }
    return min;
  }

}
