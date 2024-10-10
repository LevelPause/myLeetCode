package com.hyperboat.题单.位运算.基础;
/*
* https://leetcode.cn/problems/power-of-four/description/
* */
public class _342_4的幂 {

  class Solution {

    public boolean isPowerOfFour(int n) {
      return n > 0 && (n & -n) == n && (32 - Integer.numberOfLeadingZeros(n)) % 2 == 1;
    }
  }
}
