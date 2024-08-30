package com.hyperboat.daily.y2024.m08.d31;

public class _3127_构造相同颜色的正方形 {

  class Solution {

    public boolean canMakeSquare(char[][] grid) {
      int[][] dirs = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}};
      for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
          int[] cnt = new int[2];
          for (int[] dir : dirs) {
            if (grid[i + dir[0]][j + dir[1]] == 'B') {
              cnt[0]++;
            } else {
              cnt[1]++;
            }
          }
          if (cnt[0] != cnt[1]) {
            return true;
          }
        }
      }
      return false;
    }
  }
}
