package com.hyperboat.daily.y2024.m08.d08;

/*
 * https://leetcode.cn/problems/find-the-integer-added-to-array-i/
 * */
public class LC3131 {

  public int addedInteger(int[] nums1, int[] nums2) {
    int n = nums1.length;
    for (int i = 1; i < n; i++) {
      if (nums1[0] < nums1[i]) {
        swap(nums1, 0, i);
      }
      if (nums2[0] < nums2[i]) {
        swap(nums2, 0, i);
      }
    }
    return nums2[0] - nums1[0];
  }

  public void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }
}
