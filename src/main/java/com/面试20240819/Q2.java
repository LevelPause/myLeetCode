package com.面试20240819;

import java.util.Arrays;

class Q2 {

  /*  [2, 6, 12, 20, 27, 36],
      [5, 13, 21, 21, 25, 30],
      [11, 20, 32, 23, 38, 41],
      [19, 26, 44, 30, 43, 43],
      [26, 28, 38, 34, 37, 44],
      [35, 33, 39, 51, 42, 43]]*/
  public int compute(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
//    dp[k]表示到达(i,j)所用的最短路径
    int[][] dp = new int[m][n];
    dp[0][0] = grid[0][0];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          continue;
        }
        int left = i > 0 ? dp[i - 1][j] : Integer.MAX_VALUE;
        int up = j > 0 ? dp[i][j - 1] : Integer.MAX_VALUE;
        dp[i][j] = Math.min(left, up) + grid[i][j];
      }
    }
    int[][] path = new int[m + n - 1][2];
    int i = m - 1;
    int j = n - 1;
    while (i != 0 || j != 0) {
      path[i + j][0] = i;
      path[i + j][1] = j;
      int l = i > 0 ? dp[i - 1][j] : Integer.MAX_VALUE;
      int u = i > 0 ? dp[i][j - 1] : Integer.MAX_VALUE;
      if (l < u) {
        i--;
      } else {
        j--;
      }
    }
    System.out.println(Arrays.deepToString(path));
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    int[][] grids = new int[][]{
        {2, 4, 6, 8, 7, 9},
        {3, 8, 9, 1, 4, 5},
        {6, 9, 12, 2, 15, 11},
        {8, 7, 18, 7, 13, 2},
        {7, 2, 10, 4, 3, 7},
        {9, 5, 6, 17, 5, 1}
    };
    System.out.println(new Q2().compute(grids));


  }
}
