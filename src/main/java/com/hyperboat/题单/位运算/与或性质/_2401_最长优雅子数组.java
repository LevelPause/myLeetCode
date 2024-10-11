package com.hyperboat.题单.位运算.与或性质;

/*
 * https://leetcode.cn/problems/longest-nice-subarray/description/
 * */
public class _2401_最长优雅子数组 {

  class Solution {

    public int longestNiceSubarray(int[] nums) {
      int n = nums.length;
      int ans = 0, or = 0, l = 0;
      for (int r = 0; r < n; r++) {
        while ((or & nums[r]) > 0) {
          or ^= nums[l++];
        }
        or |= nums[r];
        ans = Math.max(r - l + 1, ans);
      }
      return ans;
    }
  }
}
