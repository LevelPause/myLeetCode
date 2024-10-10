package com.hyperboat.题单.位运算.异或性质;

/*
 * https://leetcode.cn/problems/maximum-xor-after-operations/description/
 * */
public class _2317_操作后的最大异或和 {

  class Solution {

    public int maximumXOR(int[] nums) {
      int ans = 0;
      for (int x : nums) {
        ans |= x;
      }
      return ans;
    }
  }
}
