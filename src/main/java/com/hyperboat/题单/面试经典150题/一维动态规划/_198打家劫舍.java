package com.hyperboat.题单.面试经典150题.一维动态规划;

/*
 * https://leetcode.cn/problems/house-robber/?envType=study-plan-v2&envId=top-interview-150
 * */
class _198打家劫舍 {

  public int rob(int[] nums) {
    int n = nums.length;
    int dp0 = 0;
    int dp1 = 0;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans = Math.max(dp0 + nums[i], dp1);
      dp0 = dp1;
      dp1 = ans;
    }
    return ans;
  }
}
