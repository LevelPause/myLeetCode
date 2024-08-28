package com.hyperboat.daily.y2024.m08.d29;

/*
 * https://leetcode.cn/problems/check-if-grid-satisfies-conditions/
 * */
public class _3142_判断矩阵是否满足条件 {

  class Solution {

    public boolean satisfiesConditions(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if ((i < m - 1 && grid[i][j] != grid[i + 1][j]) || (j < n - 1 && grid[i][j] == grid[i][j
              + 1])) {
            return false;
          }
        }
      }
      return true;
    }
  }
}
