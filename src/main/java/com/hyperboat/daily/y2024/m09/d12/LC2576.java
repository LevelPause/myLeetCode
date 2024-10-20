package com.hyperboat.daily.y2024.m09.d12;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/find-the-maximum-number-of-marked-indices/description/
 * */
class LC2576 {

  class Solution {

    public int maxNumOfMarkedIndices(int[] nums) {
      Arrays.sort(nums);
      int l = 0;
      int n = nums.length;
      for (int r = (n + 1) / 2; r < n; r++) {
        if (nums[l] * 2 <= nums[r]) {
          l++;
        }
      }
      return l * 2;
    }
  }
}
