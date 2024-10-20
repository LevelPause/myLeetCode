package com.hyperboat.题单.面试经典150题.二分查找;

/*
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/?envType=study-plan-v2&envId=top-interview-150
 * */
class _4寻找两个正序数组的中位数 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // 012345
    int m = nums1.length;
    int n = nums2.length;
    if (m > n) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int l = 0;
    int r = m;
    int totalL = (m + n + 1) / 2;
    int edgeL = 0;
    int edgeR = 0;
    while (l <= r) {
      int i = (l + r) / 2;
      int j = totalL - i;
      int numI = i == m ? Integer.MAX_VALUE : nums1[i];
      int numI_1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
      int numJ = j == n ? Integer.MAX_VALUE : nums2[j];
      int numJ_1 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
      if (numI_1 <= numJ) {
        edgeL = Math.max(numI_1, numJ_1);
        edgeR = Math.min(numI, numJ);
        l = i + 1;
      } else {
        r = i - 1;
      }
    }
    return ((m + n) & 1) == 1 ? edgeL : (edgeL + edgeR) / 2.0d;
  }
}
