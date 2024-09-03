package com.hyperboat.题单.hot100.二分;

public class _35_搜索插入位置 {

  class Solution {

    public int searchInsert(int[] nums, int target) {
      int n = nums.length;
      int l = 0;
      int r = n - 1;
      while (l < r) {
        int m = (r + l) >> 1;
        if (nums[m] == target) {
          return m;
        } else if (nums[m] < target) {
          l = m + 1;
        } else {
          r = m - 1;
        }
      }
      return l + 1;
    }
  }
}
