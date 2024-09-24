package com.hyperboat.题单.dp._3_背包._3_1_01背包;

/*
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 * */
public class _416_分割等和子集 {

  class Solution {

    public boolean canPartition(int[] nums) {
      int sum = 0;
      int max = 0;
      for (int x : nums) {
        sum += x;
        max = Math.max(max, x);
      }
      //总和为奇数或者最大元素大于总和的一半
      if (sum % 2 != 0 || max > sum >> 1) {
        return false;
      }
      int half = sum / 2;
      boolean[] dp = new boolean[half + 1];
      dp[0] = true;
      int min = 0;
      for (int x : nums) {
        min = Math.min(x + min, half);
        for (int i = min; i >= x; i--) {
          dp[i] |= dp[i - x];
          if (dp[half]) {
            return true;
          }
        }
      }
      return false;
    }
  }
}
