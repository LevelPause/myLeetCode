package com.hyperboat.daily.y2024.m08.d15;

import java.util.Arrays;
import java.util.List;

public class LC3148 {

  public int maxScore(List<List<Integer>> grid) {
    int m = grid.size();
    int n = grid.get(0).size();
    /*dp[i][j]表示当前[i][j]位置的最小值*/
    int[][] dp = new int[m + 1][n + 1];
    for (int[] i : dp) {
      Arrays.fill(i, Integer.MAX_VALUE / 2);
    }
    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int preMin = Math.min(dp[i][j + 1], dp[i + 1][j]);
        int x = grid.get(i).get(j);
        ans = Math.max(ans, x - preMin);
        dp[i + 1][j + 1] = Math.min(x, preMin);
      }
    }
    return ans;
  }
}
