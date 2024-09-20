package com.hyperboat.题单.dp._2_网格图dp._2_1_基础;

import java.util.List;

public class _120_三角形最小路径和 {

  class Solution {

    public int minimumTotal(List<List<Integer>> t) {
      int n = t.size();
      int[] dp = new int[n + 1];
      for (int i = n - 1; i >= 0; i--) {
        for (int j = 0; j <= i; j++) {
          dp[j] = Math.min(dp[j], dp[j + 1]) + t.get(i).get(j);
        }
      }
      return dp[0];
    }
  }
}
