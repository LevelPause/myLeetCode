package com.hyperboat.题单.dp._1入门dp._1_3最大子数组和;

public class _2321_拼接数组的最大分数 {

  class Solution {

    // 本题本质上是求最大连续子数组和,
    // 操作的数组是数组1和数组2的差值数组, 差值连续和最大时, 交换后就能得到最大的数组和
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
      return Math.max(max(nums1, nums2), max(nums2, nums1));
    }

    // 方法1
    private int max(int[] n1, int[] n2) {
      int sum1 = 0;
      int n = n1.length;
      int diff = 0;
      int max = Integer.MIN_VALUE;
      int preMinSum = 0;
      for (int i = 0; i < n; i++) {
        sum1 += n1[i];
        diff += n2[i] - n1[i];
        max = Math.max(max, diff - preMinSum);
        preMinSum = Math.min(preMinSum, diff);
      }
      return sum1 + max;
    }

    // 方法2
    private int max2(int[] nums1, int[] nums2) {
      int n = nums1.length;
      int sum1 = 0, sum2 = 0, pre1 = 0, pre2 = 0, curr = 0;
      int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
        sum1 += nums1[i];
        sum2 += nums2[i];
        curr += nums2[i] - nums1[i];
        max1 = Math.max(max1, curr - pre1);
        max2 = Math.max(max2, -curr - pre2);
        pre1 = Math.min(pre1, curr);
        pre2 = Math.min(pre2, -curr);
      }
      return Math.max(sum1 + max1, sum2 + max2);
    }
  }
}
