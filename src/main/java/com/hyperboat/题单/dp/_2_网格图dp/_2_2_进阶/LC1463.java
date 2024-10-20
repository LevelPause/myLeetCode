package com.hyperboat.题单.dp._2_网格图dp._2_2_进阶;

import java.util.Arrays;

/**
 * 1463. 摘樱桃II
 * <p>
 * https://leetcode.cn/problems/cherry-pickup-ii/
 */
class LC1463 {

  private int m;
  private int n;
  private int[][] grid;
  private int[] dirs;
  private int[][][] memo;

  public int cherryPickup(int[][] grid) {
    m = grid.length;
    n = grid[0].length;
    this.grid = grid;
    dirs = new int[]{-1, 0, 1};
    memo = new int[m][n][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        Arrays.fill(memo[i][j], -1);
      }
    }
    return dfs(0, 0, n - 1);
  }

  private int dfs(int i, int j, int y) {
    if (i == m || j < 0 || j >= n || y < 0 || y >= n) {
      return 0;
    }
    if (memo[i][j][y] != -1) {
      return memo[i][j][y];
    }
    int ans = 0;
    for (int j1 : dirs) {
      for (int y1 : dirs) {
        ans = Math.max(ans, dfs(i + 1, j + j1, y + y1));
      }
    }
    ans += grid[i][j] + (j == y ? 0 : grid[i][y]);
    return memo[i][j][y] = ans;
  }


}
