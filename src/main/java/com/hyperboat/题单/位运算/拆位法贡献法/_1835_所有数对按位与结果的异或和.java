package com.hyperboat.题单.位运算.拆位法贡献法;

/*
 * https://leetcode.cn/problems/find-xor-sum-of-all-pairs-bitwise-and/description/
 * */
class _1835_所有数对按位与结果的异或和 {

  class Solution {

    public int getXORSum(int[] arr1, int[] arr2) {
      int xor1 = 0;
      int xor2 = 0;
      for (int x : arr1) {
        xor1 ^= x;
      }
      for (int x : arr2) {
        xor2 ^= x;
      }
      return xor1 & xor2;
    }
  }
}
