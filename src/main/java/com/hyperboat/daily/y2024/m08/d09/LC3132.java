package com.hyperboat.daily.y2024.m08.d09;

import java.util.Arrays;
/**
* https://leetcode.cn/problems/find-the-integer-added-to-array-ii/description/
* */
public class LC3132 {

  public int minimumAddedInteger(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    for (int i = 2; i > 0; i--) {
      int j = 0;
      int x = nums2[0] - nums1[i];
      for (int k = i; k < nums1.length; k++) {
        if (nums2[j] == nums1[k] + x && ++j == nums2.length) {
          return x;
        }
      }
    }
    return nums2[0] - nums1[0];
  }
}
