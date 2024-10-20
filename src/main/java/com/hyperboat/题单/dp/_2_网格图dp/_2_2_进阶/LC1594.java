package com.hyperboat.题单.dp._2_网格图dp._2_2_进阶;

/**
 * 1594. 矩阵的最大非负积
 * <p>
 * https://leetcode.cn/problems/maximum-non-negative-product-in-a-matrix/description/
 */
class LC1594 {

  public int maxProductPath(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int mod = (int) 1e9 + 7;
    long[] min = new long[n];
    long[] max = new long[n];
    min[0] = max[0] = grid[0][0];
    for (int i = 1; i < n; i++) {
      min[i] = max[i] = max[i - 1] * grid[0][i];
    }
    for (int i = 1; i < m; i++) {
      min[0] *= grid[i][0];
      max[0] *= grid[i][0];
      for (int j = 1; j < n; j++) {
        int x = grid[i][j];
        long currMax = Math.max(max[j], max[j - 1]);
        long currMin = Math.min(min[j], min[j - 1]);
        if (x < 0) {
          max[j] = currMin * x;
          min[j] = currMax * x;
        } else {
          max[j] = currMax * x;
          min[j] = currMin * x;
        }
      }
    }
    return (int) Math.max(max[n - 1] % mod, -1);
  }
}
