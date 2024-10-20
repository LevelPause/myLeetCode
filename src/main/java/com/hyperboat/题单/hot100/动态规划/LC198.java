package com.hyperboat.题单.hot100.动态规划;

/**
 * 198. 打家劫舍
 * <p>
 * https://leetcode.cn/problems/house-robber/description/
 */
class LC198 {

  public int rob(int[] nums) {
    int dp0 = 0;
    int dp1 = nums[0];
    int n = nums.length;
    for (int i = 1; i < n; i++) {
      int t = dp1;
      dp1 = Math.max(dp0 + nums[i], dp1);
      dp0 = t;
    }
    return dp1;
  }

}
