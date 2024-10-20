package com.hyperboat.题单.dp._1入门dp._1_3最大子数组和;

/**
 * 1749. 任意子数组和的绝对值的最大值
 * <p>
 * https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/description/
 */
class LC1749 {

  public int maxAbsoluteSum(int[] nums) {
    int ans = 0;
    int max = 0;
    int min = 0;
    for (int num : nums) {
      max = Math.max(max, 0) + num;
      min = Math.min(min, 0) + num;
      ans = Math.max(ans, Math.max(Math.abs(max), Math.abs(min)));
    }
    return ans;
  }

}
