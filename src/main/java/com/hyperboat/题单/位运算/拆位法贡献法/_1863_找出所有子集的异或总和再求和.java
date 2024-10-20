package com.hyperboat.题单.位运算.拆位法贡献法;

/*
 * https://leetcode.cn/problems/sum-of-all-subset-xor-totals/description/
 * */
class _1863_找出所有子集的异或总和再求和 {

  class Solution {

    public int subsetXORSum(int[] nums) {
      int n = nums.length;
      int or = 0;
      for (int x : nums) {
        or |= x;
      }
      return or << (n - 1);
    }
  }
}
