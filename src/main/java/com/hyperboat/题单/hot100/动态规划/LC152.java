package com.hyperboat.题单.hot100.动态规划;

/**
 * 152. 乘积最大子数组
 * <p>
 * https://leetcode.cn/problems/maximum-product-subarray/description/
 */
class LC152 {

  public int maxProduct(int[] nums) {
    int ans = nums[0];
    int n = nums.length;
    long max = nums[0];
    long min = nums[0];

    for (int i = 1; i < n; i++) {
      long tMax = max;
      long tMin = min;
      max = Math.max(tMax * nums[i], Math.max(tMin * nums[i], nums[i]));
      min = Math.min(Math.min(tMax * nums[i], nums[i]), tMin * nums[i]);
      ans = Math.max((int) max, ans);
    }

    return ans;
  }

}
