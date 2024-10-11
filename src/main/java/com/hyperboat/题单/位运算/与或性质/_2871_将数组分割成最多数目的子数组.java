package com.hyperboat.题单.位运算.与或性质;

/*
 * https://leetcode.cn/problems/split-array-into-maximum-number-of-subarrays/description/
 * */
public class _2871_将数组分割成最多数目的子数组 {

  class Solution {

    public int maxSubarrays(int[] nums) {
      int ans = 0;
      int curr = -1;
      for (int x : nums) {
        curr &= x;
        if (curr == 0) {
          ans++;
          curr = -1;
        }
      }
      return Math.max(ans, 1);
    }
  }
}
