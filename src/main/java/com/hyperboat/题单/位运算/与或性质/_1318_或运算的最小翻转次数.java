package com.hyperboat.题单.位运算.与或性质;

/*
 * https://leetcode.cn/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/
 * */
public class _1318_或运算的最小翻转次数 {

  class Solution {

    public int minFlips(int a, int b, int c) {
      return Integer.bitCount((a | b) ^ c) + Integer.bitCount(a & b & ~c);
    }
  }
}
