package com.hyperboat.题单.位运算.拆位法贡献法;

/**
 * 1863. 找出所有子集的异或总和再求和
 * <p>
 * https://leetcode.cn/problems/sum-of-all-subset-xor-totals/description/
 */
class LC1863 {

  public int subsetXORSum(int[] nums) {
    int n = nums.length;
    int or = 0;
    for (int x : nums) {
      or |= x;
    }
    return or << (n - 1);
  }

}
