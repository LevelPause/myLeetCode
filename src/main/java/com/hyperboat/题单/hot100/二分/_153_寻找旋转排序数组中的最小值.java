package com.hyperboat.题单.hot100.二分;

public class _153_寻找旋转排序数组中的最小值 {

  class Solution {

    public int findMin(int[] nums) {
      int n = nums.length;
      int l = 0;
      int r = n - 1;
      int min = nums[0];
      while (l <= r) {
        int m = (l + r) >> 1;
        if (nums[0] <= nums[m]) {
          l = m - 1;
        } else {
          min = nums[m];
          r = m + 1;
        }
      }
      return min;
    }
  }
}
