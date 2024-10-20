package com.hyperboat.题单.位运算.基础;

/*
 * https://leetcode.cn/problems/counting-bits/description/
 * */
class _338_比特位计数 {

  class Solution {

    public int[] countBits(int n) {
      int[] ans = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        ans[i] = ans[i >> 1] + (i & 1);
      }
      return ans;
    }
  }
}
