package com.hyperboat.题单.位运算.基础;

/*
 * https://leetcode.cn/problems/binary-number-with-alternating-bits/description/
 * */
class _693_交替位二进制数 {

  class Solution {

    public boolean hasAlternatingBits(int n) {
      int len = Integer.SIZE - Integer.numberOfLeadingZeros(n);
      int mask1 = 0x55555555 & ((1 << len) - 1);
      int mask2 = 0xAAAAAAAA & ((1 << len) - 1);
      return mask1 == n || mask2 == n;
    }
  }
}
