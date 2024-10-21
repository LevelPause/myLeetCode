package com.hyperboat.题单.面试经典150题.二分查找;

/*
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 * */
class LC34 {

  public int[] searchRange(int[] nums, int target) {
    int first = binarySearch(nums, target);
    if (first == nums.length || nums[first] != target) {
      return new int[]{-1, -1};
    }
    int last = binarySearch(nums, target + 1) - 1;
    return new int[]{first, last};
  }

  public int binarySearch(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    while (l <= r) {
      int m = l + (r - l) / 2;
      if (target <= nums[m]) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    return l;
  }
}
