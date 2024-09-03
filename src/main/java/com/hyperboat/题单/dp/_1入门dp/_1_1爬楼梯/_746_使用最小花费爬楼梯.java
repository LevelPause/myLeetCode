package com.hyperboat.题单.dp._1入门dp._1_1爬楼梯;

/*
 * https://leetcode.cn/problems/min-cost-climbing-stairs/description/
 * */
public class _746_使用最小花费爬楼梯 {

  class Solution {

    public int minCostClimbingStairs(int[] cost) {
      int dp0 = 0;
      int dp1 = 0;
      int n = cost.length;
      for (int i = 2; i <= n; i++) {
        int t = Math.min(dp0 + cost[i - 2], dp1 + cost[i - 1]);
        dp0 = dp1;
        dp1 = t;
      }
      return dp1;
    }
  }
}
