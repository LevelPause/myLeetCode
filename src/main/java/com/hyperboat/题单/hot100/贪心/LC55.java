package com.hyperboat.题单.hot100.贪心;

/**
 * 55. 跳跃游戏
 * <p>
 * https://leetcode.cn/problems/jump-game/description/
 */
class LC55 {

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
