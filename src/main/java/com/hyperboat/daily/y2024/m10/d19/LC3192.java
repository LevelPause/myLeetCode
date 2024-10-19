package com.hyperboat.daily.y2024.m10.d19;

/*
 * https://leetcode.cn/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-ii/description/
 * */
public class LC3192 {

  public int minOperations(int[] nums) {
    var ans = 0;
    for (int num : nums) {
      if (((ans & 1) ^ num) == 0) {
        ans++;
      }
    }
    return ans;
  }
}
