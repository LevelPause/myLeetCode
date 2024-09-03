package com.hyperboat.题单.hot100.动态规划;

import java.util.ArrayList;
import java.util.List;

public class _300_最长递增子序列 {

  class Solution {

    public int lengthOfLIS(int[] nums) {
      return nlogn(nums);
    }

    public int n2(int[] nums) {
      int n = nums.length;
      int[] dp = new int[n];
      dp[0] = 1;
      int ans = 1;
      for (int i = 1; i < n; i++) {
        dp[i] = 1;
        for (int j = 0; j < i; j++) {
          if (nums[i] > nums[j]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
          }
        }
        ans = Math.max(ans, dp[i]);
      }
      return ans;
    }

    public int nlogn(int[] nums) {
      int n = nums.length;
      List<Integer> ansList = new ArrayList<>();
      ansList.add(nums[0]);
      for (int i = 1; i < n; i++) {
        int tail = ansList.size() - 1;
        if (nums[i] > ansList.get(tail)) {
          ansList.add(nums[i]);
        } else {
          int l = 0, r = tail;
          while (l <= r) {
            int m = (l + r) >> 1;
            if (nums[i] <= ansList.get(m)) {
              r = m - 1;
            } else {
              l = m + 1;
            }
          }
          ansList.set(l, nums[i]);
        }
      }
      return ansList.size();
    }
  }
}
