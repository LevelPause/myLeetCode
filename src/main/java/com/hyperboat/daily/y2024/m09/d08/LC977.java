package com.hyperboat.daily.y2024.m09.d08;

public class LC977 {

  class Solution {

    public int[] sortedSquares(int[] nums) {
      return doublePointer1(nums);
    }

    public int[] doublePointer1(int[] nums) {
      int n = nums.length;
      int[] ans = new int[n];
      int l = 0, r = n - 1, pos = n - 1;
      while (l <= r) {
        int left = nums[l] * nums[l];
        int right = nums[r] * nums[r];
        if (left > right) {
          ans[pos--] = left;
          l++;
        } else {
          ans[pos--] = right;
          r--;
        }
      }
      return ans;
    }

    public int[] doublePointer2(int[] nums) {
      int n = nums.length;
      int[] ans = new int[n];
      if (nums[0] >= 0) {
        for (int i = 0; i < ans.length; i++) {
          ans[i] = nums[i] * nums[i];
        }
        return ans;
      }
      int r = 0;
      while (r < n && nums[r] < 0) {
        r++;
      }
      int l = r - 1;
      int index = 0;
      while (l >= 0 || r < n) {
        if (l < 0) {
          ans[index++] = nums[r] * nums[r++];
          continue;
        }
        if (r >= n) {
          ans[index++] = nums[l] * nums[l--];
          continue;
        }
        if (nums[l] * nums[l] < nums[r] * nums[r]) {
          ans[index++] = nums[l] * nums[l--];
        } else {
          ans[index++] = nums[r] * nums[r++];
        }
      }
      return ans;

    }
  }
}
