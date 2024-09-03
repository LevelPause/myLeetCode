package com.hyperboat.题单.hot100.技巧;

public class _31_下一个排列 {

  class Solution {

    public void nextPermutation(int[] nums) {
      int n = nums.length;
      int i = n - 2;
      while (i >= 0 && nums[i] >= nums[i + 1]) {
        i--;
      }
      if (i >= 0) {
        int j = n - 1;
        while (j > i && nums[i] >= nums[j]) {
          j--;
        }
        swap(nums, i, j);
      }

      reverse(nums, i + 1, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
      while (l < r) {
        swap(nums, l, r);
        l++;
        r--;
      }
    }

    private void swap(int[] nums, int i, int j) {
      int t = nums[i];
      nums[i] = nums[j];
      nums[j] = t;
    }
  }
}
