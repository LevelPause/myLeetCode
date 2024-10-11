package com.hyperboat.题单.位运算.与或性质;

/*
 * https://leetcode.cn/problems/longest-subarray-with-maximum-bitwise-and/description/
 * */
public class _2419_按位与最大的最长子数组 {

  class Solution {

    //统计最大数的连续出现次数即可
    public int longestSubarray(int[] nums) {
      int max = 0;
      for (int x : nums) {
        max = Math.max(max, x);
      }
      int ans = 1;
      int i = 0;
      while (i < nums.length) {
        if (nums[i] == max) {
          int cnt = 1;
          while (++i < nums.length && nums[i] == max) {
            cnt++;
          }
          ans = Math.max(ans, cnt);
        } else {
          i++;
        }
      }
      return ans;
    }
  }
}
