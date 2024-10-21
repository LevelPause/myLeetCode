package com.hyperboat.题单.位运算.基础;

/**
 * 2220. 转换数字的最少位翻转次数
 * <p>
 * https://leetcode.cn/problems/minimum-bit-flips-to-convert-number/description/
 */
class LC2220 {

  public int minBitFlips(int start, int goal) {
    return Integer.bitCount(start ^ goal);
  }
}
