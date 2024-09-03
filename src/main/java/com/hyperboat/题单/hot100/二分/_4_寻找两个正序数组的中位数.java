package com.hyperboat.题单.hot100.二分;

public class _4_寻找两个正序数组的中位数 {

  class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int m = nums1.length;
      int n = nums2.length;
      //保证m<=n
      if (m > n) {
        return findMedianSortedArrays(nums2, nums1);
      }
      int l = 0;
      int r = m;
      int half = (m + n + 1) >> 1;
      int resL = 0, resR = 0;
      while (l <= r) {
        int i = (l + r) >> 1;
        int j = half - i;
        int numI = i == m ? Integer.MAX_VALUE : nums1[i];
        int numI_1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int numJ = j == n ? Integer.MAX_VALUE : nums2[j];
        int numJ_1 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        if (numI_1 <= numJ) {
          resL = Math.max(numI_1, numJ_1);
          resR = Math.min(numI, numJ);
          l = i + 1;
        } else {
          r = i - 1;
        }
      }
      return ((m + n) & 1) == 1 ? resL : (resL + resR) / 2.0d;
    }
  }
}
