package com.hyperboat.题单.dp._1入门dp._1_2打家劫舍;

/**
 * 213. 打家劫舍II
 * <p>
 * https://leetcode.cn/problems/house-robber-ii/description/
 */
class LC213 {

  //对于首尾相连的, 就抢两遍, 一遍不抢头, 一遍不抢尾, 二者取最大值即可
  public int rob(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return nums[0];
    }
    return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
  }

  public int rob(int[] nums, int l, int r) {
    int dp0 = 0;
    int dp1 = nums[l];
    for (int i = l + 1; i <= r; i++) {
      int t = dp1;
      dp1 = Math.max(dp1, dp0 + nums[i]);
      dp0 = t;
    }
    return dp1;
  }

}
