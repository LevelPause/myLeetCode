package com.hyperboat.题单.dp._2_网格图dp._2_2_进阶;

/**
 * 2328. 网格图中递增路径的数目
 * <p>
 * https://leetcode.cn/problems/number-of-increasing-paths-in-a-grid/
 */
class LC2328 {

  private int m;
  private int n;
  private int[][] grid;
  private int[][] memo;
  private int mod;
  private int[][] dirs;

  public int countPaths(int[][] grid) {
    m = grid.length;
    n = grid[0].length;
    this.grid = grid;
    dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    memo = new int[m][n];
    mod = (int) 1e9 + 7;
    int ans = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (memo[i][j] == 0) {
          ans = (ans + dfs(i, j)) % mod;
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
      if (x >= 0 && x < m && y >= 0 && y < n && grid[i][j] < grid[x][y]) {
        ans = (ans + dfs(x, y)) % mod;
      }
    }
    return memo[i][j] = ans;
  }

}
