package com.hyperboat.题单.位运算.思维题;

/**
 * https://leetcode.cn/problems/minimum-impossible-or/description/
 */
class _2568_最小无法得到的或值 {

  class Solution {

    public int minImpossibleOR(int[] nums) {
      var or = 0;
      for (var x : nums) {
        if ((x & (x - 1)) == 0) {
          or |= x;
        }
      }
      or = ~or;
      return or & -or;
    }
  }
}
