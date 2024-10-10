package com.hyperboat.题单.位运算.异或性质;

/*
 * https://leetcode.cn/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/description/
 * */
public class _2997_使数组异或和等于K的最少操作次数 {

  class Solution {

    public int minOperations(int[] nums, int k) {
      for (int x : nums) {
        k ^= x;
      }
      return Integer.bitCount(k);
    }
  }
}
