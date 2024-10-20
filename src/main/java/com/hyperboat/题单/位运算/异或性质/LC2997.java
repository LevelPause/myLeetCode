package com.hyperboat.题单.位运算.异或性质;

/**
 * 2997. 使数组异或和等于K的最少操作次数
 * <p>
 * https://leetcode.cn/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/description/
 */
class LC2997 {

  public int minOperations(int[] nums, int k) {
    for (int x : nums) {
      k ^= x;
    }
    return Integer.bitCount(k);
  }

}
