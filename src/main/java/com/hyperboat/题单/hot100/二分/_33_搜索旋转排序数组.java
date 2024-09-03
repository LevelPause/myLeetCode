package com.hyperboat.题单.hot100.二分;

public class _33_搜索旋转排序数组 {

  class Solution {

    public int search(int[] nums, int target) {
      return binarySearchOnce(nums, target);
    }

    public int binarySearchOnce(int[] nums, int target) {
      int n = nums.length;
      int l = 0;
      int r = n - 1;
      while (l <= r) {
        int m = (l + r) >> 1;
        if (nums[m] == target) {
          return m;
        }
        if (nums[0] <= nums[m]) {
          if (nums[0] <= target && target < nums[m]) {
            r = m - 1;
          } else {
            l = m + 1;
          }
        } else {
          if (nums[m] < target && target <= nums[n - 1]) {
            l = m + 1;
          } else {
            r = m - 1;
          }
        }

      }
      return -1;
    }

    public int binarySearchTwice(int[] nums, int target) {
      int n = nums.length;
      int l = 0;
      int r = n - 1;
      int min = 0;
      while (l <= r) {
        int m = (l + r) >> 1;
        if (nums[0] < nums[m]) {
          l = m + 1;
        } else {
          r = m - 1;
          min = m;
        }
      }
      l = min;
      r = l + n - 1;
      while (l <= r) {
        int m = (l + r) >> 1;
        int index = m % n;
        if (nums[index] == target) {
          return index;
        }
        if (target < nums[index]) {
          r = m - 1;
        } else {
          l = m + 1;
        }
      }
      return -1;
    }
  }
}
