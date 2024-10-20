package com.hyperboat.题单.dp._2_网格图dp._2_2_进阶;

/**
 * 329. 矩阵中的最长递增路径
 * <p>
 * https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/
 */
class LC329 {

  private int[][] matrix;
  private int m;
  private int n;
  private int[][] memo;
  private int[][] dirs;

  public int longestIncreasingPath(int[][] matrix) {
    this.matrix = matrix;
    m = matrix.length;
    n = matrix[0].length;
    memo = new int[m][n];
    dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int ans = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (memo[i][j] == 0) {
          ans = Math.max(ans, dfs(i, j));
        }
      }
    }
    return ans;
  }

  private int dfs(int i, int j) {
    if (memo[i][j] != 0) {
      return memo[i][j];
    }
    int ans = 1;
    for (int[] dir : dirs) {
      int x = i + dir[0];
      int y = j + dir[1];
      if (x >= 0 && y >= 0 && x < m && y < n && matrix[i][j] < matrix[x][y]) {
        ans = Math.max(ans, dfs(x, y) + 1);
      }
    }
    return memo[i][j] = ans;
  }

}
