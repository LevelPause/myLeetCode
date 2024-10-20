package com.hyperboat.daily.y2024.m10.d20;

/**
 * 908. 最小差值 I
 * <p>
 * https://leetcode.cn/problems/smallest-range-i/description/
 */
class LC908 {

  public int smallestRangeI(int[] nums, int k) {
    var max = 0;
    var min = 10000;
    for (int x : nums) {
      max = Math.max(x, max);
      min = Math.min(x, min);
    }
    var score = max - min - k * 2;
    return Math.max(score, 0);
  }
}
