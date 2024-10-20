package com.hyperboat.题单.dp._1入门dp._1_3最大子数组和;

/**
 * 918. 环形子数组的最大和
 * <p>
 * https://leetcode.cn/problems/maximum-sum-circular-subarray/description/
 */
class LC918 {

  public int maxSubarraySumCircular(int[] nums) {
    int finalMax = nums[0];
    int tMax = 0;
    int tMin = 0;
    int finalMin = 0;
    int sum = 0;
    for (int num : nums) {
      tMax = Math.max(tMax, 0) + num;
      tMin = Math.min(tMin, 0) + num;
      finalMax = Math.max(tMax, finalMax);
      finalMin = Math.min(tMin, finalMin);
      sum += num;
    }
    return finalMax > 0 ? Math.max(finalMax, sum - finalMin) : finalMax;
  }

}
