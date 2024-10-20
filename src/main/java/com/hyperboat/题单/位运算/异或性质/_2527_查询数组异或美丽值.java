package com.hyperboat.题单.位运算.异或性质;

/*
 * https://leetcode.cn/problems/find-xor-beauty-of-array/description/
 * */
class _2527_查询数组异或美丽值 {

  class Solution {

    public int xorBeauty(int[] nums) {
      int ans = 0;
      for (int x : nums) {
        ans ^= x;
      }
      return ans;
    }
  }
}
