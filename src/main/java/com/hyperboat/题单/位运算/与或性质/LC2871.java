package com.hyperboat.题单.位运算.与或性质;

/**
 * 2871. 将数组分割成最多数目的子数组
 * <p>
 * https://leetcode.cn/problems/split-array-into-maximum-number-of-subarrays/description/
 */
class LC2871 {

  public int maxSubarrays(int[] nums) {
    int ans = 0;
    int curr = -1;
    for (int x : nums) {
      curr &= x;
      if (curr == 0) {
        ans++;
        curr = -1;
      }
    }
    return Math.max(ans, 1);
  }

}
