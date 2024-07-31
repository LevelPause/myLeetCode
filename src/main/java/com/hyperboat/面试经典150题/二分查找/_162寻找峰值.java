package com.hyperboat.面试经典150题.二分查找;

/*
 * https://leetcode.cn/problems/find-peak-element/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _162寻找峰值 {

  public int findPeakElement(int[] nums) {
    int l = 0;
    int r = nums.length - 1;
    while (l < r) {
      int mid = l + (r - l) >> 2;
      if (nums[mid] > nums[mid + 1]) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }
}
