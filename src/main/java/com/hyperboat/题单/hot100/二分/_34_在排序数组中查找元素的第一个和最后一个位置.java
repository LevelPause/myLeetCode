package com.hyperboat.题单.hot100.二分;

public class _34_在排序数组中查找元素的第一个和最后一个位置 {

  class Solution {

    public int[] searchRange(int[] nums, int target) {
      int l = binarySearch(nums, target);
      if (l == nums.length || nums[l] != target) {
        return new int[]{-1, -1};
      }
      int r = binarySearch(nums, target + 1);
      return new int[]{l, r};
    }

    private int binarySearch(int[] nums, int target) {
      int n = nums.length;
      int l = 0;
      int r = n - 1;
      while (l <= r) {
        int m = (l + r) >> 1;
        if (target <= nums[m]) {
          r = m - 1;
        } else {
          l = m + 1;
        }
      }
      return l;
    }
  }
}
