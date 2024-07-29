package com.hyperboat.daily.y2024.m7.d20;

import java.util.ArrayList;
import java.util.List;

//  https://leetcode.cn/problems/minimum-moves-to-spread-stones-over-grid/description/
public class _2850将石头分散到网格图的最少移动次数 {

  // dfs 回溯   (提前剪枝的枚举)
  public int minimumMoves(int[][] grid) {
    List<int[]> zeros = new ArrayList<>();
    List<int[]> needMoved = new ArrayList<>();
    for (int i = 0; i < grid.length; i++) {
      int[] row = grid[i];
      for (int j = 0; j < row.length; j++) {
        int item = row[j];
        if (item == 0) {
          zeros.add(new int[]{i, j});
        }
        if (item > 1) {
          needMoved.add(new int[]{i, j});
        }
      }
    }
    return dfs(needMoved, zeros, grid, 0, 0);
  }

  public int dfs(List<int[]> needMoved, List<int[]> zeros, int[][] grid, int index, int step) {
    if (index == zeros.size()) {
      return step;
    }
    int ans = Integer.MAX_VALUE;
    for (int k = 0; k < needMoved.size(); k++) {
      int i = needMoved.get(k)[0];
      int j = needMoved.get(k)[1];
      if (grid[i][j] > 1) {
        grid[i][j]--;
        int subStep = Math.abs(i - zeros.get(index)[0]) + Math.abs(j - zeros.get(index)[1]);
        ans = Math.min(ans, dfs(needMoved, zeros, grid, index + 1, step + subStep));
        grid[i][j]++;
      }
    }
    return ans;
  }
}
