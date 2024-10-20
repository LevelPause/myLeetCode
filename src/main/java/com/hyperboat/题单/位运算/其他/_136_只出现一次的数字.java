package com.hyperboat.题单.位运算.其他;

/**
 * https://leetcode.cn/problems/single-number/description/
 */
class _136_只出现一次的数字 {

  class Solution {

    public int singleNumber(int[] nums) {
      var xor = 0;
      for (int x : nums) {
        xor ^= x;
      }
      return xor;
    }
  }
}
