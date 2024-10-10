package com.hyperboat.题单.位运算.基础;

/*
 * https://leetcode.cn/problems/minimum-bit-flips-to-convert-number/description/
 * */
public class _2220_转换数字的最少位翻转次数 {

  class Solution {

    public int minBitFlips(int start, int goal) {
      return Integer.bitCount(start ^ goal);
    }
  }
}
