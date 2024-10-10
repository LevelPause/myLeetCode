package com.hyperboat.题单.位运算.基础;

/*
 * https://leetcode.cn/problems/number-of-bit-changes-to-make-two-integers-equal/description/
 * */
public class _3226_使两个整数相等的位更改次数 {

  class Solution {

    public int minChanges(int n, int k) {
      return (n & k) != k ? -1 : Integer.bitCount(n ^ k);
    }
  }
}
