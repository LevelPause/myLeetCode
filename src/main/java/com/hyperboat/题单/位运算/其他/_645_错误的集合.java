package com.hyperboat.题单.位运算.其他;

/**
 * https://leetcode.cn/problems/set-mismatch/description/
 */
public class _645_错误的集合 {

  class Solution {

    public int[] findErrorNums(int[] nums) {
      var sumN = 0;
      var sumN2 = 0L;
      var sumX = 0;
      var sumX2 = 0L;
      for (int i = 0; i < nums.length; i++) {
        sumN += i + 1;
        sumN2 += (long) (i + 1) * (i + 1);
        sumX += nums[i];
        sumX2 += (long) nums[i] * nums[i];
      }
      var d1 = sumX - sumN;
      var d2 = sumX2 - sumN2;
      var d = d2 / d1;
      var a = (int) (d + d1) / 2;
      var b = (int) (d - d1) / 2;
      return new int[]{a, b};
    }
  }
}
