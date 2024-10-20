package com.hyperboat.竞赛.双周赛;

/*
 * https://leetcode.cn/problems/find-the-power-of-k-size-subarrays-i/description/
 * */
class Q1_Q2_长度为K的子数组的能量值I {

  static class Solution {

    public int[] resultsArray(int[] nums, int k) {
      int n = nums.length;
      int[] ans = new int[n - k + 1];
      int[] dp = new int[n];
      for (int i = 0; i < n; i++) {
        dp[i] = i > 0 && nums[i] == nums[i - 1] + 1 ? dp[i - 1] + 1 : 1;
        if (i >= k - 1) {
          ans[i - (k - 1)] = i == 0 || dp[i] >= k ? nums[i] : -1;
        }
      }
      return ans;
    }
  }

}
