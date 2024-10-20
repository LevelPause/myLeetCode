package com.hyperboat.题单.位运算.其他;

/**
 * https://leetcode.cn/problems/keep-multiplying-found-values-by-two/description/
 */
class _2154_将找到的值乘以2 {

  class Solution {

    public int findFinalValue(int[] nums, int original) {
      var mask = 0;
      for (int x : nums) {
        var k = x / original;
        if (x % original == 0 && (k & (k - 1)) == 0) {
          mask |= k;
        }
      }
      mask = ~mask;
      return original * (mask & -mask);
    }
  }
}
