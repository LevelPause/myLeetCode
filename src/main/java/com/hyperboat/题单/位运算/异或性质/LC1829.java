package com.hyperboat.题单.位运算.异或性质;

/**
 * 1829. 每个查询的最大异或值
 *
 * https://leetcode.cn/problems/maximum-xor-for-each-query/description/
 * */
class LC1829 {

  public int[] getMaximumXor(int[] nums, int maximumBit) {
    int max = (1 << maximumBit) - 1;
    int xor = 0;
    int n = nums.length;
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
      int x = nums[i];
      xor ^= x;
      ans[n - 1 - i] = xor ^ max;
    }
    return ans;
  }

}
