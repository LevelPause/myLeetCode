package com.hyperboat.题单.位运算.异或性质;

/*
 * https://leetcode.cn/problems/find-the-original-array-of-prefix-xor/description/
 * */
public class _2433_找出前缀异或的原始数组 {

  class Solution {

    public int[] findArray(int[] pref) {
      for (int i = pref.length - 1; i > 0; i--) {
        pref[i] ^= pref[i - 1];
      }
      return pref;
    }
  }
}
