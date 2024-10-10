package com.hyperboat.题单.位运算.异或性质;

/*
 * https://leetcode.cn/problems/decode-xored-array/description/
 * */
public class _1720_解码异或后的数组 {

  class Solution {

    public int[] decode(int[] encoded, int first) {
      int n = encoded.length;
      int[] ans = new int[n + 1];
      ans[0] = first;
      for (int i = 1; i <= n; i++) {
        ans[i] = ans[i - 1] ^ encoded[i - 1];
      }
      return ans;
    }
  }
}
