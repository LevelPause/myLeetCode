package com.hyperboat.题单.dp._2_网格图dp._2_2_进阶;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/dungeon-game/
 * */
public class _174_地下城游戏 {

  class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
      int m = dungeon.length;
      int n = dungeon[0].length;
      //dp[i][j]表示从i,j走到终点所需要的最少的生命值, 倒着求解dp, 最终dp[0][0]即答案
      int[][] dp = new int[m + 1][n + 1];
      for (int i = 0; i < m; i++) {
        Arrays.fill(dp[i], Integer.MAX_VALUE);
      }
      dp[m][n - 1] = dp[m - 1][n] = 1;
      for (int i = m - 1; i >= 0; i--) {
        for (int j = n - 1; j >= 0; j--) {
          int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
          dp[i][j] = Math.max(min, 1);
        }
      }
      return dp[0][0];
    }
  }
}
