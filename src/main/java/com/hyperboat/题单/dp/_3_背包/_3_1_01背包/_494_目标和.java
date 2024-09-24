package com.hyperboat.题单.dp._3_背包._3_1_01背包;

/*
 * https://leetcode.cn/problems/target-sum/
 * */
public class _494_目标和 {

  class Solution {

    public int findTargetSumWays(int[] nums, int target) {
      int sum = 0;
      for (int num : nums) {
        sum += num;
      }

      int diff = sum - target;
      if (diff < 0 || diff % 2 == 1) {
        return 0;
      }
      //half为选取为负号的数和
      // 假设选取为负号的所有数和为a, 正号的所有数和为b;
      // 那么有: a + b = sum; b-a = target;
      // 从而得出a = (sum-target)/2
      // 如果(sum-target)/2 有余数, 说明无解
      int half = diff / 2;
      int[] dp = new int[half + 1];
      dp[0] = 1;
      for (int x : nums) {
        for (int i = half; i >= x; i--) {
          dp[i] += dp[i - x];
        }
      }
      return dp[half];
    }
  }
}
