package com.hyperboat.题单.位运算.与或性质;

import java.util.HashMap;

/*
 * https://leetcode.cn/problems/minimum-sum-of-values-by-dividing-array/description/
 * */
class _3117_划分数组得到最小的值之和 {

  class Solution {

    private int[] nums;
    private int[] andValues;
    private HashMap<Long, Integer> memo;
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
      return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }

    public int dfs(int i, int j, int and) {
      if (m - i < n - j) {
        return Integer.MAX_VALUE / 2;
      }
      if (j == n) {
        return i == m ? 0 : Integer.MAX_VALUE / 2;
      }
      and &= nums[i];
      long mask = (long) i << 36 | (long) j << 32 | and;
      //  String mask = "i" + i + "j" + j + "and" + and;
      if (memo.containsKey(mask)) {
        return memo.get(mask);
      }
      int res = dfs(i + 1, j, and);
      if (and == andValues[j]) {
        res = Math.min(res, dfs(i + 1, j + 1, -1) + nums[i]);
      }
      memo.put(mask, res);
      return res;
    }

  }
}
