package com.hyperboat.daily.y2024.m10.d18;

/*
 * https://leetcode.cn/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/
 * */
public class LC3191 {

  public int minOperations(int[] nums) {
    int n = nums.length;
    int ans = 0;
    for (int i = 0; i < n - 2; i++) {
      if (nums[i] == 0) { // 必须操作
        nums[i + 1] ^= 1;
        nums[i + 2] ^= 1;
        ans++;
      }
    }
    return nums[n - 2] != 0 && nums[n - 1] != 0 ? ans : -1;
  }
}
