package com.hyperboat.题单.位运算.思维题;

/**
 * https://leetcode.cn/problems/minimum-operations-to-make-the-integer-zero/description/
 */
public class _2749_得到整数零需要执行的最少操作数 {

  class Solution {

    public int makeTheIntegerZero(int num1, int num2) {
      for (var k = 1L; k <= num1 - num2 * k; k++) {
        if (k >= Long.bitCount(num1 - (long) num2 * k)) {
          return (int) k;
        }
      }
      return -1;
    }
  }
}
