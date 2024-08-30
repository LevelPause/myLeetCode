package com.hyperboat.hot100.贪心;

public class _45_跳跃游戏II {

  class Solution {

    public int jump(int[] nums) {
      int maxR = 0;
      int n = nums.length;
      int step = 0;
      int end = 0;
      for (int i = 0; i < n; i++) {
        maxR = Math.max(maxR, i + nums[i]);
        if (i == end) {
          end = maxR;
          step++;
        }
      }
      return step;
    }
  }
}
