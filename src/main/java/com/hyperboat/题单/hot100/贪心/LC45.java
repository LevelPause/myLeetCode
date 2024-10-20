package com.hyperboat.题单.hot100.贪心;

/**
 * 45. 跳跃游戏II
 * <p>
 * https://leetcode.cn/problems/jump-game-ii/description/
 */
class LC45 {

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
