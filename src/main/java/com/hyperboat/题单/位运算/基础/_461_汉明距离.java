package com.hyperboat.题单.位运算.基础;

/*
 * https://leetcode.cn/problems/hamming-distance/
 * */
public class _461_汉明距离 {

  class Solution {

    public int hammingDistance(int x, int y) {
      return Integer.bitCount(x ^ y);
    }
  }
}
