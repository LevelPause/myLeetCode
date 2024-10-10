package com.hyperboat.daily.y2024.m10.d09;

/*
 * https://leetcode.cn/problems/find-subarray-with-bitwise-or-closest-to-k/description/
 * */
public class _3171_找到按位或最接近K的子数组 {

  class Solution {

    public int minimumDifference(int[] nums, int k) {
      int ans = Integer.MAX_VALUE;
      int n = nums.length;
      for (int i = 0; i < n; i++) {
        int x = nums[i];
        ans = Math.min(ans, Math.abs(x - k));
        for (int j = i - 1; j >= 0 && (nums[j] | x) != nums[j]; j--) {
          nums[j] |= x;
          ans = Math.min(ans, Math.abs(nums[j] - k));
          if (nums[j] > k) {
            break;
          }
          if (ans == 0) {
            return ans;
          }
        }
      }
      return ans;
    }
  }
}
