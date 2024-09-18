package com.hyperboat.竞赛.双周赛139;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.cn/problems/find-a-safe-walk-through-a-grid/
 * */
public class Q2 {

  class Solution {

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
      int m = grid.size();
      int n = grid.get(0).size();
      int[][] mask = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
      Deque<int[]> dq = new LinkedList<>();
      int[][] cost = new int[m][n];
      cost[0][0] = health - grid.get(0).get(0);
      dq.offer(new int[]{0, 0, health - grid.get(0).get(0)});

      while (!dq.isEmpty()) {
        int[] poll = dq.poll();
        if (poll[2] <= 0) {
          continue;
        }
        if (poll[0] == m - 1 && poll[1] == n - 1) {
          return true;
        }
        for (int[] ints : mask) {
          int x = ints[0] + poll[0];
          int y = ints[1] + poll[1];
          if (check(x, y, m, n) && poll[2] - cost[x][y] > grid.get(x).get(y)) {
            int curr = poll[2] - grid.get(x).get(y);
            cost[x][y] = curr;
            if (curr > 0) {
              dq.offerLast(new int[]{x, y, curr});
            }
          }
        }
      }
      return false;
    }

    private boolean check(int x, int y, int m, int n) {
      return x >= 0 && x < m && y >= 0 && y < n;
    }
  }
}
