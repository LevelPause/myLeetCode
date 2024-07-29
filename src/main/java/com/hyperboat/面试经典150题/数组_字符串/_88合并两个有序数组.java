package com.hyperboat.面试经典150题.数组_字符串;

/**
 * @author zhangweigang
 * @date 2023年10月18日 9:18
 */
public class _88合并两个有序数组 {

  /*
   * 整体思路就是将nums2中的n个数插入到nums1中
   * 理论上来讲时间复杂度应该是m+n
   * */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int tail = m + n - 1;
    m--;
    n--;
    int curr;
    while (n >= 0 || m >= 0) {
      if (n == -1) {
        curr = nums1[m--];
      } else if (m == -1) {
        curr = nums2[n--];
      } else {
        curr = nums1[m] >= nums2[n] ? nums1[m--] : nums2[n--];
      }
      nums1[tail--] = curr;
    }
  }
}
