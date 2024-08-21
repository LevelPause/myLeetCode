package com.hyperboat.hot100.图论;

import java.util.Deque;
import java.util.LinkedList;

public class _994_腐烂的橘子 {

  class Solution {

    public int orangesRotting(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      Deque<int[]> dq = new LinkedList<>();
      int fresh = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          int x = grid[i][j];
          if (x == 1) {
            fresh++;
          }
          if (x == 2) {
            dq.offerLast(new int[]{i, j});
          }
        }
      }
      int[][] mask = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
      int ans = 0;
      while (fresh > 0 && !dq.isEmpty()) {
        ans++;
        int size = dq.size();
        for (int i = 0; i < size; i++) {
          int[] poll = dq.pollFirst();
          int x = poll[0];
          int y = poll[1];
          for (int[] item : mask) {
            int p = x + item[0];
            int q = y + item[1];
            if (p >= 0 && p < m && q >= 0 && q < n && grid[p][q] == 1) {
              fresh--;
              if (fresh == 0) {
                return ans;
              }
              grid[p][q] = 2;
              dq.offerLast(new int[]{p, q});
            }
          }
        }

      }
      return fresh == 0 ? ans : -1;
    }
  }
}
