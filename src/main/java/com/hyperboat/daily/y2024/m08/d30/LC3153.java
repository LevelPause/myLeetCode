package com.hyperboat.daily.y2024.m08.d30;

class LC3153 {

  static class Solution {

    public long sumDigitDifferences(int[] nums) {
      long ans = 0L;
      int n = nums.length;
      int len = String.valueOf(nums[0]).length();
      int[][] cnt = new int[len][10];
      for (int i = 0; i < len; i++) {
        for (int j = 0; j < n; j++) {
          cnt[i][nums[j] % 10]++;
          nums[j] /= 10;
        }
      }
      for (int[] line : cnt) {
        for (int i = 0; i < 10; i++) {
          for (int j = i + 1; j < 10; j++) {
            if (line[i] > 0 && line[j] > 0) {
              ans += (long) line[i] * line[j];
            }
          }
        }
      }
      return ans;
    }
  }
}
