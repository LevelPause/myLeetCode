package com.hyperboat.题单.dp._1入门dp._1_2打家劫舍;

/*
 * https://leetcode.cn/problems/delete-and-earn/
 * */
public class _740_删除并获得点数 {

  class Solution {

    public int deleteAndEarn(int[] nums) {
      int max = 0;
      for (int num : nums) {
        max = Math.max(max, num);
      }
      int[] sum = new int[max + 1];
      for (int num : nums) {
        sum[num] += num;
      }
      return rob(sum);
    }

    private int rob(int[] nums) {
      int dp0 = 0;
      int dp1 = nums[0];
      for (int i = 0; i < nums.length; i++) {
        int t = dp1;
        dp1 = Math.max(dp1, dp0 + nums[i]);
        dp0 = t;
      }
      return dp1;
    }
  }
}
