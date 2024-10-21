package com.hyperboat.题单.位运算.基础;

/**
 * 461. 汉明距离
 * <p>
 * https://leetcode.cn/problems/hamming-distance/
 */
class LC461 {

  public int hammingDistance(int x, int y) {
    return Integer.bitCount(x ^ y);
  }

}
