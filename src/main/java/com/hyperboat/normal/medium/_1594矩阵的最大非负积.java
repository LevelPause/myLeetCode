package com.hyperboat.normal.medium;

/**
 * @author zhangweigang
 * @date 2023年10月18日 5:47
 */
public class _1594矩阵的最大非负积 {

  public int maxProductPath(int[][] grid) {
    int mod = 1000000007;
    int m = grid.length, n = grid[0].length;
    //这里一定要写long而不是int, int会在乘积的过程中溢出导致结果不正确
    long[][] dpMax = new long[m][n];
    long[][] dpMin = new long[m][n];
    dpMax[0][0] = dpMin[0][0] = grid[0][0];
    if (grid[0][0] == 0) {
      return 0;
    }
    //当i==0时,只能往右走, 所以得到的积为第一行的积
    for (int j = 1; j < n; j++) {
      dpMax[0][j] = dpMin[0][j] = grid[0][j] * dpMax[0][j - 1];
    }

    //当j==0时,只能往下走, 所以得到的积为第一列的积
    for (int i = 1; i < m; i++) {
      dpMax[i][0] = dpMin[i][0] = grid[i][0] * dpMax[i - 1][0];
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (grid[i][j] < 0) {
          dpMax[i][j] = Math.min(dpMin[i - 1][j], dpMin[i][j - 1]) * grid[i][j];
          dpMin[i][j] = Math.max(dpMax[i - 1][j], dpMax[i][j - 1]) * grid[i][j];
        } else {
          dpMax[i][j] = Math.max(dpMax[i - 1][j], dpMax[i][j - 1]) * grid[i][j];
          dpMin[i][j] = Math.min(dpMin[i - 1][j], dpMin[i][j - 1]) * grid[i][j];
        }
      }
    }
    return (int) Math.max(dpMax[m - 1][n - 1] % mod, -1);
  }

}
