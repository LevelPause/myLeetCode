package com.hyperboat.daily.y2024.m09.d10;

public class LC2552 {

  class Solution {

    public long countQuadruplets(int[] nums) {
      long ans = 0L;
      int n = nums.length;
      int[] pre = new int[n + 1];
      for (int j = 0; j < n; j++) {
        int cnt = 0;

        for (int k = n - 1; k > j; k--) {
          if (nums[j] > nums[k]) {
            ans += (long) pre[nums[k]] * cnt;
          } else {
            cnt++;
          }
        }
        for (int i = nums[j] + 1; i <= n; i++) {
          pre[i]++;
        }
      }
      return ans;
    }
  }
}
