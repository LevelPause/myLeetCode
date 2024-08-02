package com.hyperboat.daily.y2024.m08.d02;

/*
 * https://leetcode.cn/problems/right-triangles/
 * */
public class _128直角三角形 {

  public long numberOfRightTriangles(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[] countM = new int[m];
    int[] countN = new int[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          countM[i]++;
          countN[j]++;
        }
      }
    }
    long ans = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          ans += (long) (countM[i] - 1) * (countN[j] - 1);
        }
      }
    }
    return ans;
  }
}
