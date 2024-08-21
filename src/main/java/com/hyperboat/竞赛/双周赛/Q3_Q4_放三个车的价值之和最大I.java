package com.hyperboat.竞赛.双周赛;

public class Q3_Q4_放三个车的价值之和最大I {

  static class Solution {

    private int m;
    private int n;
    private int[][] board;
    long ans = Integer.MIN_VALUE;

    public long maximumValueSum(int[][] board) {
      m = board.length;
      n = board[0].length;
      this.board = board;
      dfs(0, 0, 0, new int[3][2]);
      return ans;
    }

    public void dfs(int i, int j, int k, int[][] cars) {

      if (i == m || j == n) {
        if (k == 3) {
          long sum = board[cars[0][0]][cars[0][1]]
              + board[cars[1][0]][cars[1][1]]
              + board[cars[2][0]][cars[2][1]];
          System.out.println(sum);
          ans = Math.max(ans, sum);
        }
        return;
      }

      if (j < n - 1) {
        dfs(i, j + 1, k, cars);
      } else {
        dfs(i + 1, j, k, cars);
      }
      for (int p = 0; p < k; p++) {
        if (cars[p][0] == i || cars[p][1] == j) {
          return;
        }
      }
      cars[k][0] = i;
      cars[k][1] = j;
      dfs(0, 0, k + 1, cars);
    }
  }

}
