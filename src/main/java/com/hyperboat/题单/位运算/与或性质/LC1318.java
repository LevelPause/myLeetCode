package com.hyperboat.题单.位运算.与或性质;

/**
 * 1318. 或运算的最小翻转次数
 * <p>
 * https://leetcode.cn/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/
 */
class LC1318 {

  public int minFlips(int a, int b, int c) {
    return Integer.bitCount((a | b) ^ c) + Integer.bitCount(a & b & ~c);
  }

}
