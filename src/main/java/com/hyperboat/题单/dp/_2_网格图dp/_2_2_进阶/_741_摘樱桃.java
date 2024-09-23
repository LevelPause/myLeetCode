package com.hyperboat.题单.dp._2_网格图dp._2_2_进阶;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/cherry-pickup/
 * */
public class _741_摘樱桃 {

  //这道题容易产生的错误思路就是两次遍历，每次取最优，但是两次局部最优加起来等于全局最优
  //所以应该将两次放在同时遍历, 取每一步的和最大值即可得到全局最优解
  class Solution {

    private int[][][] memo;
    private int n;
    private int[][] grid;

    public int cherryPickup(int[][] grid) {
      n = grid.length;
      if (n == 1) {
        return grid[0][0] == -1 ? 0 : grid[0][0];
      }
      this.grid = grid;
      memo = new int[2 * n - 1][n][n];
      for (int[][] ints : memo) {
        for (int[] anInt : ints) {
          Arrays.fill(anInt, -1);
        }
      }
      return Math.max(dfs(2 * n - 2, n - 1, n - 1), 0);
    }

    private int dfs(int step, int j, int k) {
      if (step < j || step < k || j < 0 || k < 0 || grid[step - j][j] < 0
          || grid[step - k][k] < 0) {
        return Integer.MIN_VALUE;
      }
      if (memo[step][j][k] != -1) {
        return memo[step][j][k];
      }
      int ans = 0;
      int max = Math.max(
          Math.max(dfs(step - 1, j, k), dfs(step - 1, j, k - 1)),
          Math.max(dfs(step - 1, j - 1, k), dfs(step - 1, j - 1, k - 1)));
      ans = max + grid[step - j][j] + (j == k ? 0 : grid[step - k][k]);
      return memo[step][j][k] = ans;
    }
  }
}
