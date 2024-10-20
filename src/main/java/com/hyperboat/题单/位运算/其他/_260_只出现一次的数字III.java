package com.hyperboat.题单.位运算.其他;

/**
 * https://leetcode.cn/problems/single-number-iii/description/
 */
class _260_只出现一次的数字III {

  class Solution {

    public int[] singleNumber(int[] nums) {
      var xor = 0;
      for (var x : nums) {
        xor ^= x;
      }
      var lowbit = xor & -xor;
      var ans = new int[2];
      for (var x : nums) {
        var index = (lowbit & x) == 0 ? 0 : 1;
        ans[index] ^= x;
      }
      return ans;
    }
  }
}
