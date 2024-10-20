package com.hyperboat.题单.位运算.拆位法贡献法;

/*
 * https://leetcode.cn/problems/bitwise-xor-of-all-pairings/description/
 * */
class _2425_所有数对的异或和 {

  class Solution {

    public int xorAllNums(int[] nums1, int[] nums2) {
      int m = nums1.length;
      int n = nums2.length;
      int xor1 = 0;
      int xor2 = 0;
      for (int x : nums1) {
        xor1 ^= x;
      }
      for (int y : nums2) {
        xor2 ^= y;
      }
      return ((m & 1) == 1 ? xor1 : 0) ^ ((n & 1) == 1 ? xor2 : 0);
    }
  }
}
