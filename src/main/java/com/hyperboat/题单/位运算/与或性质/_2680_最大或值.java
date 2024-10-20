package com.hyperboat.题单.位运算.与或性质;

/*
 * https://leetcode.cn/problems/maximum-or/description/
 * */
class _2680_最大或值 {

  class Solution {

    public long maximumOr(int[] nums, int k) {
      int or = 0, multi = 0;
      for (int x : nums) {
        multi |= or & x;
        or |= x;
      }
      long ans = 0L;
      for (int x : nums) {
        ans = Math.max(ans, (long) x << k | or ^ x | multi);
      }
      return ans;
    }
  }
}
