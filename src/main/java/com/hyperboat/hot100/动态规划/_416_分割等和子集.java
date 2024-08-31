package com.hyperboat.hot100.动态规划;

public class _416_分割等和子集 {

  static class Solution {

    public boolean canPartition(int[] nums) {
      int n = nums.length;
      int sum = 0;
      for (int i = 0; i < n; i++) {
        sum += nums[i];
      }
      if (sum % 2 != 0) {
        return false;
      }
      int half = sum / 2;
      boolean[] dp = new boolean[half + 1];
      dp[0] = true;
      for (int i = 0; i < n; i++) {
        for (int j = half; j >= nums[i]; j--) {
          dp[j] |= dp[j - nums[i]];
        }
      }
      return dp[half];
    }
  }
}
