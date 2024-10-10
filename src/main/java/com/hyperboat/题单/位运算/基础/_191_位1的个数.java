package com.hyperboat.题单.位运算.基础;

/*
 * https://leetcode.cn/problems/number-of-1-bits/description/
 * */
public class _191_位1的个数 {

  class Solution {

    public int hammingWeight(int n) {
      n = (n & 0x55555555) + ((n >> 1) & 0x55555555);
      n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
      n = (n & 0x0F0F0F0F) + ((n >> 4) & 0x0F0F0F0F);
      n = (n * (0x01010101) >> 24);
      return n;
    }
  }
}
