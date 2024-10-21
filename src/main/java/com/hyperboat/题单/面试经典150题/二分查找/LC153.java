package com.hyperboat.题单.面试经典150题.二分查找;

/*
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 * */
class LC153 {

  public int findMin(int[] nums) {
    int n = nums.length;
    int l = 1;
    int r = n - 1;
    int min = nums[0];
    while (l <= r) {
      int m = l + (r - l) / 2;
      if (nums[0] > nums[m]) {
        r = m - 1;
        min = nums[m];
      } else {
        l = m + 1;
      }
    }
    return min;
  }
}
