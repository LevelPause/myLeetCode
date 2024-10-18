package com.hyperboat.daily.y2024.m08.d16;

import java.util.HashMap;

public class LC3117 {

  static class Solution {

    private int[] nums;
    private int[] andValues;
    private HashMap<String, Integer> memo;
    private int m;
    private int n;

    public int minimumValueSum(int[] nums, int[] andValues) {
      m = nums.length;
      n = andValues.length;
      if (m < n) {
        return -1;
      }
      this.nums = nums;
      this.andValues = andValues;
      memo = new HashMap<>();
      int ans = dfs(0, 0, -1);
      return ans == Integer.MIN_VALUE / 2 ? -1 : ans;
    }

    public int dfs(int i, int j, int and) {
      if (n - i < m - j) {
        return Integer.MAX_VALUE / 2;
      }
      if (j == m) {
        return i == n ? 0 : Integer.MAX_VALUE / 2;
      }
      and &= nums[i];
      String mask = "i" + i + "j" + j + "and" + and;
      if (memo.containsKey(mask)) {
        return memo.get(mask);
      }
      int res = dfs(i + 1, j, and);
      if (and == andValues[j]) {
        res = Math.min(res, dfs(j + 1, j + 1, -1) + nums[i]);
      }
      memo.put(mask, res);
      return res;
    }
  }
}
