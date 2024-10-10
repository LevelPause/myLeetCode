package com.hyperboat.题单.位运算.基础;

/*
 * https://leetcode.cn/problems/number-complement/description/
 * */
public class _476_数字的补数 {

  class Solution {

    public int findComplement(int num) {
      return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
  }
}
