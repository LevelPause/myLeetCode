package com.hyperboat.题单.dp._1入门dp._1_2打家劫舍;

public class _198_打家劫舍 {

  class Solution {

    public int rob(int[] nums) {
      int dp0 = 0;
      int dp1 = nums[0];
      int n = nums.length;
      for (int i = 1; i < n; i++) {
        int t = dp0;
        dp0 = Math.max(dp0, dp1);
        dp1 = t + nums[i];
      }
      return Math.max(dp0, dp1);
    }
  }
}
