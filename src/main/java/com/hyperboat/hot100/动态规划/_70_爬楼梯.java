package com.hyperboat.hot100.动态规划;

public class _70_爬楼梯 {

  class Solution {

    public int climbStairs(int n) {
      return O1(n);
    }

    public int On(int n) {
      int[] dp = new int[n + 1];
      dp[0] = 1;
      dp[1] = 1;
      for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
      }
      return dp[n + 1];
    }

    public int O1(int n) {
      int dp0 = 1;
      int dp1 = 1;
      for (int i = 2; i <= n; i++) {
        int t = dp1;
        dp1 = dp0 + dp1;
        dp0 = t;
      }
      return dp1;
    }

  }
}
