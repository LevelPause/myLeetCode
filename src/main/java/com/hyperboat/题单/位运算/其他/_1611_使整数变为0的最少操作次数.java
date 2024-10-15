package com.hyperboat.题单.位运算.其他;

/**
 * https://leetcode.cn/problems/minimum-one-bit-operations-to-make-integers-zero/description/
 */
public class _1611_使整数变为0的最少操作次数 {

  class Solution {

    public int minimumOneBitOperations(int n) {
      var ans = 0;
      while (n > 0) {
        ans ^= n;
        n >>= 1;
      }
      return ans;
    }
  }
}
