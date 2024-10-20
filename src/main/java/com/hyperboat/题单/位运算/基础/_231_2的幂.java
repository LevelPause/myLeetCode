package com.hyperboat.题单.位运算.基础;

/*
 * https://leetcode.cn/problems/power-of-two/description/
 * */
class _231_2的幂 {

  class Solution {

    public boolean isPowerOfTwo(int n) {
      return n > 0 && (n & -n) == n;
    }
  }
}
