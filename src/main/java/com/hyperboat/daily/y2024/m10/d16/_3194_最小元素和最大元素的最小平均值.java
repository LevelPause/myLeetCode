package com.hyperboat.daily.y2024.m10.d16;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-average-of-smallest-and-largest-elements/description/
 */
public class _3194_最小元素和最大元素的最小平均值 {

  class Solution {

    public double minimumAverage(int[] nums) {
      var n = nums.length;
      Arrays.sort(nums);
      var l = 0;
      var r = n - 1;
      var ans = Integer.MAX_VALUE;
      while (l < r) {
        var min = nums[l];
        var max = nums[r];
        ans = Math.min(min + max, ans);
        l++;
        r--;
      }
      return ans / 2.0;
    }
  }
}
