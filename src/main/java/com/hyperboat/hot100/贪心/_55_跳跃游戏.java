package com.hyperboat.hot100.贪心;

public class _55_跳跃游戏 {

  class Solution {

    public boolean canJump(int[] nums) {
      int n = nums.length;
      int maxR = 0;
      for (int i = 0; i < n; i++) {
        if (maxR >= n - 1) {
          return true;
        }
        if (i > maxR) {
          return false;
        }
        maxR = Math.max(maxR, nums[i] + i);
      }
      return true;
    }
  }
}
