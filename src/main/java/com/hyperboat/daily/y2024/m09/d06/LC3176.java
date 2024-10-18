package com.hyperboat.daily.y2024.m09.d06;

public class LC3176 {

  class Solution {

    public int maximumLength(int[] nums, int k) {
      int ans = 0;
      int n = nums.length;
      int l = 0;
      int cnt = 0;
      for (int r = 0; r < n - 1; r++) {
        if (nums[r] != nums[r + 1]) {
          cnt++;
        }
        while (cnt > k && l < r) {
          l++;
          if (nums[l - 1] != nums[l]) {
            cnt--;
            ans = Math.max(ans, r - l + 2);
            break;
          }
        }
      }
      return ans;
    }
  }
}
