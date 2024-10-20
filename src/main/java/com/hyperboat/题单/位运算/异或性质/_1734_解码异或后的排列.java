package com.hyperboat.题单.位运算.异或性质;

/*
 * https://leetcode.cn/problems/decode-xored-permutation/description/
 * */
class _1734_解码异或后的排列 {

  class Solution {

    public int[] decode(int[] encoded) {
      int n = encoded.length + 1;
      int[] ans = new int[n];
      int a = 0;
      for (int i = 0; i < n - 1; i += 2) {
        a ^= encoded[i];
      }
      int b = 0;
      for (int i = 1; i <= n; i++) {
        b ^= i;
      }
      ans[n - 1] = a ^ b;
      for (int i = n - 2; i >= 0; i--) {
        ans[i] = encoded[i] ^ ans[i + 1];
      }
      return ans;
    }
  }
}
