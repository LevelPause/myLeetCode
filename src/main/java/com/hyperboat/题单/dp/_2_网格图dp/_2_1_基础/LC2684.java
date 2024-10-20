package com.hyperboat.题单.dp._2_网格图dp._2_1_基础;

import java.util.Arrays;

/**
 * 2684. 矩阵中移动的最大次数
 * <p>
 * https://leetcode.cn/problems/maximum-number-of-moves-in-a-grid/description/
 */
class LC2684 {

  public int maxMoves(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    //dp[i] 表示能否到达当前列的第i行
    boolean[] dp = new boolean[m];
    Arrays.fill(dp, true);
    for (int j = 1; j < n; j++) {
      //pre用于记录dp[i-1], 因为在更新过程中会被覆盖
      boolean pre = false;
      // sum用于记录当前列是否有能到达的行
      boolean sum = false;
      for (int i = 0; i < m; i++) {
        boolean flag = dp[i] && grid[i][j] > grid[i][j - 1];
        if (i > 0) {
          flag |= pre && grid[i][j] > grid[i - 1][j - 1];
        }
        if (i < m - 1) {
          flag |= dp[i + 1] && grid[i][j] > grid[i + 1][j - 1];
        }
        //在更新dp[i]前先记录, 用作下一次循环的dp[i-1];
        pre = dp[i];
        dp[i] = flag;
        sum |= dp[i];
      }
      //sum==false, 意味着当前列没有能到达的行, 返回上一行即可
      if (!sum) {
        return j - 1;
      }
    }
    return n - 1;
  }

}
