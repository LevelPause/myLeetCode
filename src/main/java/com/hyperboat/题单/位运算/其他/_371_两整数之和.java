package com.hyperboat.题单.位运算.其他;

/**
 * https://leetcode.cn/problems/sum-of-two-integers/description/
 */
public class _371_两整数之和 {

  class Solution {

    public int getSum(int a, int b) {
      while (b != 0) {
        var carry = (a & b) << 1;
        a = a ^ b;
        b = carry;
      }
      return a;
    }
  }
}
