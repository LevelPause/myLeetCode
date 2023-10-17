package com.hyperboat.medium;

/**
 * @author zhangweigang
 * @date 2023年10月18日 5:47
 */
public class LC1594矩阵的最大非负积 {

  public int maxProductPath(int[][] grid) {
    int i = 0, j = 0;
    int res = dp(i, j, grid, 1);
    return res > 0 ? res % ((int) Math.pow(10, 9) + 7) : -1;
  }

  private int dp(int i, int j, int[][] grid, int res) {
    if (i == grid.length - 1 && j == grid[0].length - 1) {
      return res * grid[i][j];
    }
    if (i == grid.length - 1) {
      return res * dp(i, j + 1, grid, res);
    }
    if (j == grid[0].length - 1) {
      return res * dp(i + 1, j, grid, res);
    }
    return Math
        .max(Math.abs(res * dp(i, j + 1, grid, res)), Math.abs(res * dp(i + 1, j, grid, res)));
  }
}
