package com.hyperboat.题单.dp._1入门dp._1_3最大子数组和;

/**
 * 53. 最大子数组和
 * <p>
 * https://leetcode.cn/problems/maximum-subarray/description/
 */
class LC53 {

  public int maxSubArray(int[] nums) {
    int sum = nums[0];
    int n = nums.length;
    int ans = nums[0];
    for (int i = 1; i < n; i++) {
      sum = Math.max(0, sum) + nums[i];
      ans = Math.max(ans, sum);
    }
    return ans;
  }

}
