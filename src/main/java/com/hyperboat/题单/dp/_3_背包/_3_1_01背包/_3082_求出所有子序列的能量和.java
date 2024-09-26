package com.hyperboat.题单.dp._3_背包._3_1_01背包;

/*
 * https://leetcode.cn/problems/find-the-sum-of-the-power-of-all-subsequences/description/
 * */
public class _3082_求出所有子序列的能量和 {

  class Solution {

    public int sumOfPower(int[] nums, int k) {
      int[] dp = new int[k + 1];
      dp[0] = 1;
      int mod = (int) 1e9 + 7;
      for (int x : nums) {
        for (int j = k; j >= 0; j--) {
          // 这里的状态转移很不好理解
          // dp[i][j]表示从0~i-1选取一系列数组成子序列, 他们的和为j的方案数
          // 实际dp有三种转移: dp[i][j] = dp[i-1][j] + dp[i-1][j] + dp[i-1][j-nums[i]]
          // 假设S为当前子序列的集合, T为S的超集, U为全集, 数学表示: S ⊆ T ⊆ U; (用韦恩图表示更加方便)
          // 那么nums[i]的位置基于上述三种集合只有三种情况
          // 1. nums[i] ∈ S;                此时dp[i][j] = dp[i-1][j-nums[i]]
          // 2. nums[i] ∉ S && nums[i] ∈ T; 此时dp[i][j] = dp[i-1][j]
          // 3. nums[i] ∉ S && nums[i] ∉ T; 此时dp[i][j] = dp[i-1][j]
          // 三者组合起来即状态转移方程
          dp[j] = (dp[j] * 2 + (j >= x ? dp[j - x] : 0)) % mod;
        }
      }
      return dp[k];
    }
  }
}
