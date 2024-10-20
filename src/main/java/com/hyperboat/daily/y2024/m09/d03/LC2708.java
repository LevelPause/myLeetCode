package com.hyperboat.daily.y2024.m09.d03;

class LC2708 {

  class Solution {

    public long maxStrength(int[] nums) {
      return dp(nums);
    }

    public long dp(int[] nums) {
      int n = nums.length;
      long fMax = nums[0];
      long fMin = nums[0];
      for (int i = 1; i < n; i++) {
        int x = nums[i];
        long t = fMax;
        fMax = Math.max(Math.max(x * fMin, x * fMax), Math.max(fMax, x * fMax));
        fMin = Math.min(Math.min(x * fMin, x * t), Math.min(fMin, x * fMin));
      }
      return fMax;
    }

  }
}
